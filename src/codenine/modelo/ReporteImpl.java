package codenine.modelo;

import codenine.dto.AreaDTO;
import codenine.dto.ReporteDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteImpl {

    Conexion conn = new Conexion();
    Connection con = conn.ConeccionSQL();

    public DefaultTableModel tablaReporte(ReporteDTO dto) {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Paterno");
        Modelo.addColumn("Materno");
        Modelo.addColumn("Sexo");
        Modelo.addColumn("Cargo");
        Modelo.addColumn("Local");
        Modelo.addColumn("Ocurrencia");
        Modelo.addColumn("Fecha");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select nombre, paterno, materno, sexo,cargo,area.descripcion,ocurrencia.descripcion, fecha from asistencia\n"
                    + "inner join persona on persona.idpersona = asistencia.idpersona\n"
                    + "inner join area on area.idarea = persona.idareafk\n"
                    + "inner join ocurrencia on ocurrencia.idocurrencia = asistencia.idocurrencia\n"
                    + "where fecha between '" + dto.getFechaInicio() + "' and '" + dto.getFechaFin() + "'\n"
                    + "AND asistencia.asistencia_confirmada = 1\n"
                    + "order by fecha desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                Modelo.addRow(fila);
            }
            JOptionPane.showMessageDialog(null, "Inicio: " + dto.getFechaInicio() + " Fecha fin: " + dto.getFechaFin());
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error tabla: " + e);
        } finally {
            conn.CerrarConexion();
        }
        return Modelo;
    }
}
