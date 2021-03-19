package Logica.Verified;

import Logica.SentenciasSQL;
import Logica.Verified.Conexion;
import Logica.Verified.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLLogin {

    Conexion connect = new Conexion();
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean login(Usuarios user) {
        connection = connect.getConnection();
        sql = "select CodEmpleado, NomEmpleado, ApeEmpleado, Usuario, Contraseña from empleado "
                + "where Usuario=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (user.getContraseña().equals(rs.getString("Contraseña"))) {
                    user.setCodEmpleado(rs.getLong("CodEmpleado"));
                    user.setNomEmpleado(rs.getString("NomEmpleado"));
                    user.setApeEmpleado(rs.getString("ApeEmpleado"));
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
