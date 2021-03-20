package Logica;

import PENDIENTE.SentenciasSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLUsuarios {

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

    public boolean nuevoUsuario(Usuarios user) {
        //connection = connect.getConnection();
        sql = "Insert into empleado(CodEmpleado, NomEmpleado, ApeEmpleado, TelEmpleado, Usuario, Contraseña) "
                + "values (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, user.getCodEmpleado());
            ps.setString(2, user.getNomEmpleado());
            ps.setString(3, user.getApeEmpleado());
            ps.setLong(4, user.getTelEmpleado());
            ps.setString(5, user.getUsuario());
            ps.setString(6, user.getContraseña());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizarUsuario(Usuarios user) {
        //connection = connect.getConnection();
        sql = "UPDATE empleado SET NomEmpleado=?, ApeEmpleado=?,TelEmpleado = ?, "
                + "Usuario = ?  where CodEmpleado = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getNomEmpleado());
            ps.setString(2, user.getApeEmpleado());
            ps.setLong(3, user.getTelEmpleado());
            ps.setString(4, user.getUsuario());
            ps.setLong(5, user.getCodEmpleado());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean CambiarContraseña(Usuarios user) {
        //connection = connect.getConnection();
        sql = "UPDATE empleado SET Contraseña = ?"
                + " where Usuario = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(2, user.getUsuario());
            ps.setString(1, user.getContraseña());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean EliminarUsuario(Usuarios usuario) {
        //connection = connect.getConnection();
        sql = "delete from empleado "
                + "where CodEmpleado=? and Usuario=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, usuario.getCodEmpleado());
            ps.setString(2, usuario.getUsuario());
            ps.execute();
            if (ExisteDocumento(usuario) && ExisteUsuario(usuario)) {
                //Usuario no eliminado
                return false;
            } else {
                //Usuario Eliminado
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            //Usuario no eliminado
            return false;
        }
    }

    public boolean ExisteDocumento(Usuarios user) {
        //connection = connect.getConnection();
        sql = "select * from empleado "
                + "where CodEmpleado=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, user.getCodEmpleado());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean ExisteUsuario(Usuarios user) {
        //connection = connect.getConnection();
        sql = "select * from empleado "
                + "where Usuario=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean ConsultarUsuarios(Usuarios user) {
        //connection = connect.getConnection();
        sql = "select CodEmpleado, NomEmpleado, ApeEmpleado,TelEmpleado, Usuario, Contraseña from empleado "
                + "where CodEmpleado=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, user.getCodEmpleado());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setCodEmpleado(rs.getLong("CodEmpleado"));
                user.setNomEmpleado(rs.getString("NomEmpleado"));
                user.setApeEmpleado(rs.getString("ApeEmpleado"));
                user.setTelEmpleado(rs.getLong("TelEmpleado"));
                user.setUsuario(rs.getString("Usuario"));
                user.setContraseña(rs.getString("Contraseña"));

                return true;
            } else {

                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean restablecerPassword(Usuarios user) {
        //connection = connect.getConnection();
        String passwd = Encrypt.sha1(String.valueOf(user.getCodEmpleado()));
        try {
            sql = "UPDATE empleado SET Contraseña = ?"
                    + " where Usuario = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, passwd);
            ps.setString(2, user.getUsuario());
            ps.execute();

            sql = "select * from empleado where Usuario=? and Contraseña=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, passwd);
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }

        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex);
            return false;
        }
    }
}
