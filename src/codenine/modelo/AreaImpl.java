package codenine.modelo;

import codenine.dto.AreaDTO;
import codenine.interfaz.AreaInterfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AreaImpl implements AreaInterfaz {

    Conexion con = new Conexion();
    Connection conn = con.ConeccionSQL();

    @Override
    public void registrar(AreaDTO m) {
        String sql = "INSERT INTO area (idarea,descripcion)values(?,?)";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, m.getIdArea());
            stament.setString(2, m.getDescripcion());
            int rowsInsert = stament.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("se registro el area correctamente");
                JOptionPane.showMessageDialog(null, "se registro el area correctamente");
            }
        } catch (SQLException sqle) {
            System.out.println("Sql Exception - InsertarClase: " + sqle.getMessage());
            JOptionPane.showConfirmDialog(null, sqle.toString());
        }
    }

    @Override
    public void eliminar(AreaDTO c) {
        String sql = "delete from area where idarea=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, c.getIdArea());

            int rowsDeleted = stament.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("se elimino un area correctamente");
                JOptionPane.showMessageDialog(null, "se elimino un area correctamente");
            }

        } catch (SQLException sqle) {
            System.out.println("sql exception: " + sqle.getMessage());
        }
    }

    @Override
    public void actualizar(AreaDTO c) {

        String sql = "update area set descripcion=? where idarea=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setString(1, c.getDescripcion());
            stament.setInt(2, c.getIdArea());

            int rowsupdated = stament.executeUpdate();
            if (rowsupdated > 0) {
                System.out.println("Se actualizo el area correctamente");
                JOptionPane.showMessageDialog(null, "Se actualizo el area correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Sql Exception: " + e.getMessage());
        }
    }

    @Override
    public DefaultTableModel tabla() {
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Id");
        Modelo.addColumn("Descripcion");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select * from area";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);;
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Modelo;
    }

    @Override
    public DefaultComboBoxModel combo() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Conexion con = new Conexion();
        try {
            int b = 2;

            String sql = "select * from area";
            ResultSet rs = con.getDatos(sql);
            int n = 0;
            while (rs.next()) {

                AreaDTO per = new AreaDTO();
                per.setIdArea(rs.getInt(1));
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
}
