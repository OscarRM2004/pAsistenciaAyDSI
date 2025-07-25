package codenine.modelo;

import codenine.dto.AsistenciaDTO;
import codenine.dto.OcurrenciaDto;
import codenine.dto.AreaDTO;
import codenine.interfaz.AsistenciaInterfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AsistenciaImpl implements AsistenciaInterfaz {

    Conexion conn = new Conexion();
    Connection con = conn.ConeccionSQL();

    @Override
    public void registrar(AsistenciaDTO m) {
        String sql = "INSERT INTO asistencia VALUES(?,?,?,?)";

        try {
            m.getNombre();
            PreparedStatement stament = con.prepareStatement(sql);
            stament.setInt(1, m.getIdpersona());
            stament.setString(2, m.getFecha());
            stament.setString(3, m.getOcurrencia());
            stament.setString(4, m.getDetalle());
            int rowsInsert = stament.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("registro de asistencia correctamente");
                JOptionPane.showMessageDialog(null, "registro de asistencia correcto");
            }
        } catch (SQLException sqle) {
            System.out.println("Sql Exception - insertar Asistencia: " + m.getNombre());
            JOptionPane.showConfirmDialog(null, sqle.toString());
        }
    }

    @Override
    public void eliminar(AsistenciaDTO c) {
        String sql = "delete from asistencia where idpersona=? and fecha=?";

        try {
            PreparedStatement stament = con.prepareStatement(sql);
            stament.setInt(1, c.getIdpersona());
            stament.setString(2, c.getFecha());

            stament.executeUpdate();

            System.out.println("se elimino un registro correctamente");
            JOptionPane.showMessageDialog(null, "se elimino un Registro correctamente");

        } catch (SQLException sqle) {
            System.out.println("sql exception: " + sqle.getMessage());
        }
    }

    @Override
    public void actualizar(AsistenciaDTO c) {

        String sql = "update asistencia set ocurrencia=?, detalle=? where idpersona=? and fecha =?";

        try {
            PreparedStatement stament = con.prepareStatement(sql);

            stament.setString(1, c.getOcurrencia());
            stament.setString(2, c.getDetalle());
            stament.setInt(3, c.getIdpersona());
            stament.setString(4, c.getFecha());

            stament.executeUpdate();
            System.out.println("se Actualizo Registro correctamente");
            JOptionPane.showMessageDialog(null, "se Actualizo Registro correctamente");

        } catch (SQLException e) {
            System.out.println("Sql Exception ASDASD: " + e.getMessage());
        }
    }

    @Override
    public DefaultTableModel tabla() {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Id");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Paterno");
        Modelo.addColumn("Materno");
        Modelo.addColumn("Sexo");
        Modelo.addColumn("Cargo");
        Modelo.addColumn("Ocurrencia");
        Modelo.addColumn("Detalle");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select * from persona";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.CerrarConexion();
        }
        return Modelo;
    }

    @Override
    public DefaultComboBoxModel combo() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Conexion con = new Conexion();
        try {
            int b = 2;

            String sql = "select * from ocurrencia";
            ResultSet rs = con.getDatos(sql);
            int n = 0;
            while (rs.next()) {

                OcurrenciaDto per = new OcurrenciaDto();
                per.setIdOcurrencia(rs.getInt(1));
                per.setDescripcion(rs.getString(2));
                modelo.addElement(per);

            }
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error personal: " + e);
        } finally {
            con.CerrarConexion();
        }
        return modelo;
    }

    @Override
    public DefaultTableModel tablaAsistencia(AreaDTO area) {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("id");
        Modelo.addColumn("nombre");
        Modelo.addColumn("paterno");
        Modelo.addColumn("materno");
        Modelo.addColumn("Sexo");
        Modelo.addColumn("Cargo");
        Modelo.addColumn("ocurrencia");
        Modelo.addColumn("detalle");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select * from persona where idareafk=" + area.getIdArea() + "";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.CerrarConexion();
        }
        return Modelo;
    }
    
    public DefaultTableModel getAsistenciasPendientes(String fecha) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Persona");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("Ocurrencia");
        modelo.addColumn("Ruta Evidencia");
        modelo.addColumn("Fecha"); // Columna oculta para usarla después

        String sql = "SELECT p.idpersona, CONCAT(p.nombre, ' ', p.paterno), o.descripcion, a.detalle, a.fecha " +
                     "FROM asistencia a " +
                     "JOIN persona p ON a.idpersona = p.idpersona " +
                     "JOIN ocurrencia o ON a.idocurrencia = o.idocurrencia " +
                     "WHERE a.fecha = ? AND a.asistencia_confirmada = 0";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fecha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener asistencias pendientes: " + e.getMessage());
        }
        return modelo;
    }

    // Método para confirmar una asistencia
    public boolean confirmarAsistencia(int idPersona, String fecha) {
        String sql = "UPDATE asistencia SET asistencia_confirmada = 1 WHERE idpersona = ? AND fecha = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPersona);
            stmt.setString(2, fecha);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al confirmar asistencia: " + e.getMessage());
            return false;
        }
    }

    // Método para rechazar (eliminar) una asistencia
    public boolean rechazarAsistencia(int idPersona, String fecha) {
        String sql = "DELETE FROM asistencia WHERE idpersona = ? AND fecha = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPersona);
            stmt.setString(2, fecha);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al rechazar asistencia: " + e.getMessage());
            return false;
        }
    }
}
