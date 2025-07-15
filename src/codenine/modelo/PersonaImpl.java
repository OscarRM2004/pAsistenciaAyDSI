package codenine.modelo;

import codenine.dto.PersonaDto;
import codenine.interfaz.PersonaInterfaz;
import codenine.util.ListaEnlazada;
import codenine.util.RepositorioTemporalPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

public class PersonaImpl implements PersonaInterfaz {
    private static final Logger logger = LoggerFactory.getLogger(PersonaImpl.class);
    Conexion con = new Conexion();
    Connection conn = con.ConeccionSQL();
    RepositorioTemporalPersona repositorioTemporal = new RepositorioTemporalPersona(); // Crear instancia del repositorio temporal

    @Override
    public void registrar(PersonaDto p) {
        // La consulta SQL ahora incluye el campo web_password
        String sql = "INSERT INTO persona (idpersona, nombre, paterno, materno, sexo, cargo, idareafk, email, web_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Reutilizamos la conexión de la clase
            if (this.conn == null || this.conn.isClosed()) {
                this.conn = con.ConeccionSQL();
            }

            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, p.getIdPersona());
            stament.setString(2, p.getNombre());
            stament.setString(3, p.getApPaterno());
            stament.setString(4, p.getApMaterno());
            stament.setString(5, p.getSexo());
            stament.setString(6, p.getCargo());
            stament.setInt(7, p.getIdArea());
            stament.setString(8, p.getEmail());

            // --- PARÁMETRO NUEVO ---
            // Añadimos la contraseña al PreparedStatement.
            // Se guarda como texto plano para que el primer login en la web la convierta a hash.
            stament.setString(9, p.getWeb_password());
            // -----------------------

            int rowsInsert = stament.executeUpdate();
            if (rowsInsert > 0) {
                logger.info("Persona registrada con éxito con ID: {} y Email: {}", p.getIdPersona(), p.getEmail());
                JOptionPane.showMessageDialog(null, "Persona y cuenta web registradas correctamente");
            }
        } catch (SQLException sqle) {
            logger.error("Error de SQL al registrar persona", sqle);
            JOptionPane.showMessageDialog(null, "Error SQL al registrar: " + sqle.getMessage());
        } 
        // No cerramos la conexión aquí para poder reutilizarla.
    }

    @Override
    public void eliminar(PersonaDto p) {
        // Usamos la conexión de la clase. Asegurémonos de que esté activa.
        if (this.conn == null) {
            this.conn = con.ConeccionSQL();
        }

        try {
            // Iniciar una transacción
            conn.setAutoCommit(false);

            // 1. Eliminar los registros de asistencia asociados
            String sqlAsistencia = "DELETE FROM asistencia WHERE idpersona = ?";
            try (PreparedStatement stmtAsistencia = conn.prepareStatement(sqlAsistencia)) {
                stmtAsistencia.setInt(1, p.getIdPersona());
                stmtAsistencia.executeUpdate();
                System.out.println("Se eliminaron las asistencias de la persona con ID: " + p.getIdPersona());
            }

            // 2. Eliminar a la persona
            String sqlPersona = "DELETE FROM persona WHERE idpersona = ?";
            try (PreparedStatement stmtPersona = conn.prepareStatement(sqlPersona)) {
                stmtPersona.setInt(1, p.getIdPersona());
                int rowsDeleted = stmtPersona.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Se eliminó una persona correctamente");
                }
            }

            // Si todo salió bien, confirmar la transacción
            conn.commit();
            JOptionPane.showMessageDialog(null, "Persona y sus registros eliminados correctamente.");

        } catch (SQLException sqle) {
            System.out.println("Error en la transacción de eliminación: " + sqle.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + sqle.getMessage());
            try {
                // Si algo falla, revertir todos los cambios
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex.getMessage());
            }
        } finally {
            try {
                // Volver al modo de autocommit
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                System.out.println("Error al restaurar autocommit: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actualizar(PersonaDto p) {
        // Usaremos un StringBuilder para construir la consulta SQL dinámicamente.
        StringBuilder sql = new StringBuilder("UPDATE persona SET nombre=?, paterno=?, materno=?, sexo=?, cargo=?, idareafk=?, email=?");

        // Si el objeto PersonaDto contiene una contraseña, añadimos la parte de la contraseña a la consulta SQL.
        if (p.getWeb_password() != null && !p.getWeb_password().isEmpty()) {
            sql.append(", web_password=?");
        }
        sql.append(" WHERE idpersona=?");

        try {
            if (this.conn == null || this.conn.isClosed()) {
                this.conn = con.ConeccionSQL();
            }

            PreparedStatement stament = conn.prepareStatement(sql.toString());

            // Asignamos los parámetros que siempre están presentes
            stament.setString(1, p.getNombre());
            stament.setString(2, p.getApPaterno());
            stament.setString(3, p.getApMaterno());
            stament.setString(4, p.getSexo());
            stament.setString(5, p.getCargo());
            stament.setInt(6, p.getIdArea());
            stament.setString(7, p.getEmail());

            // Usamos un índice para los parámetros que pueden variar
            int parametroIndex = 8;
            if (p.getWeb_password() != null && !p.getWeb_password().isEmpty()) {
                stament.setString(parametroIndex, p.getWeb_password());
                parametroIndex++; // Incrementamos el índice para el siguiente parámetro
            }

            // Asignamos el último parámetro, que es el idpersona
            stament.setInt(parametroIndex, p.getIdPersona());

            int rowsupdated = stament.executeUpdate();
            if (rowsupdated > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó una Persona correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Sql Exception al actualizar: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL al actualizar: " + e);
        }
    }

    // Método para mostrar las personas en el repositorio temporal
    public void mostrarPersonasTemporales() {
        repositorioTemporal.mostrarPersonas();
    }

    @Override
    public DefaultTableModel tabla() {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("ID");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Paterno");
        Modelo.addColumn("Materno");
        Modelo.addColumn("Sexo");
        Modelo.addColumn("Cargo");
        Modelo.addColumn("Área");
        Modelo.addColumn("Email"); // Nuevo

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "SELECT idpersona, nombre, paterno, materno, sexo, cargo, area.descripcion, email FROM persona "
                    + "INNER JOIN area ON area.idarea = persona.idareafk";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getObject(8) != null ? rs.getString(8) : ""; // Nuevo
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.CerrarConexion();
        }
        return Modelo;
    }

    @Override
    public DefaultComboBoxModel combo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Dentro de la clase PersonaImpl

    // Necesitarás una librería para hashear, o puedes hacerlo en PHP.
    // Para simplificar, aquí guardaremos el hash directamente desde PHP.
    // Este método desde Java establecerá la contraseña.
    public boolean actualizarPasswordWeb(String email, String password) {
        // ¡IMPORTANTE! En un entorno real, la contraseña debe ser "hasheada".
        // PHP tiene password_hash(). Desde Java es más complejo.
        // Aquí vamos a guardar la contraseña en texto plano, asumiendo
        // que es un sistema interno, pero esto NO es seguro.
        // La forma correcta sería llamar a un script PHP desde Java para que la hashee.
        // Por simplicidad del ejemplo, lo haremos directo.

        // **NOTA:** La implementación web en PHP sí usará hashing.
        // El objetivo de este botón es establecer la contraseña inicial.

        String sql = "UPDATE persona SET web_password = ? WHERE email = ?";

        try (Connection c = con.ConeccionSQL();
             PreparedStatement st = c.prepareStatement(sql)) {

            // El hasheo se hará en el lado web (PHP).
            // Java solo establece la contraseña para que el usuario pueda iniciar sesión por primera vez.
            // Opcional: Podrías usar una librería como jBCrypt en Java.
            st.setString(1, password); 
            st.setString(2, email);

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar contraseña: " + e.getMessage());
            return false;
        }
    }
    
    public DefaultTableModel tablaCredencialesWeb() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Email (Usuario)");

        Object[] fila = new Object[modelo.getColumnCount()];

        // Usamos la conexión existente 'conn' de la clase
        // y nos aseguramos de que no esté cerrada.
        if (this.conn == null) {
            this.conn = con.ConeccionSQL();
        }

        try {
            String sql = "SELECT idpersona, email FROM persona WHERE email IS NOT NULL AND email != ''";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar tabla de credenciales: " + e);
        }
        // No cerramos la conexión aquí, ya que puede ser usada por otros métodos.

        return modelo;
    }
}
