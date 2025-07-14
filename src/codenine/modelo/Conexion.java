package codenine.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    Connection cn;
    // URL apuntando a la IP o dominio de tu VPS
    String url = "jdbc:mysql://136.0.42.211:3306/ASISTENCIA?serverTimezone=UTC";
    String drv = "com.mysql.cj.jdbc.Driver";
    // Credenciales del usuario que creaste en el VPS
    String usu = "asistencia_user";
    String pass = "StrongPassword123!"; // <-- La contraseña que definiste

    public Statement stm = null;
    ResultSet rs = null;

    public Connection ConeccionSQL() {
        try {
            Class.forName(drv);
            cn = DriverManager.getConnection(url, usu, pass);
            stm = cn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion remota: " + e.getMessage());
            e.printStackTrace();
        }
        return cn;
    }

    public void CerrarConexion() {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        } catch (SQLException sqle) {
            System.out.println("Sql Exception: " + sqle.getMessage());
        }
    }

    public ResultSet getDatos(String com) {
        try {
            this.ConeccionSQL();
            rs = stm.executeQuery(com);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error getDatos: " + e);
        }
        return rs;
    }
}