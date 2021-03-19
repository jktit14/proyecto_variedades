package Logica;

import Logica.Verified.Usuarios;
import Logica.Verified.Encrypt;
import Logica.Verified.Productos;
import Logica.Verified.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SentenciasSQL {

    Conexion connect = new Conexion();
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean registro(Usuarios user) {
        connection = connect.getConnection();
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

    public boolean actualizacion(Usuarios user) {
        connection = connect.getConnection();
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

    public boolean changePasswd(Usuarios user) {
        connection = connect.getConnection();
        sql = "UPDATE empleado SET Contraseña = ?"
                + " where Usuario = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(2, user.getUsuario());
            ps.setString(1, user.getContraseña());
            //System.out.println("CONSULTA - " + ps);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean restablecerPassword(Usuarios user) {
        connection = connect.getConnection();
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

    public boolean ConsultarUsuarios(Usuarios user) {
        connection = connect.getConnection();
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
                connect.stopConection();
                return true;
            } else {
                connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean UsuarioExiste(Usuarios user) {
        connection = connect.getConnection();
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

    public boolean DocumentoExiste(Usuarios user) {
        connection = connect.getConnection();
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

    public boolean crearCategoria(Productos producto) {
        connection = connect.getConnection();
        sql = "Insert into categoria_productos(CodCategoria,Descripcion) "
                + "values (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
            ps.setString(2, producto.getDescripcionCategoria());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ModificarCategoria(Productos producto) {
        connection = connect.getConnection();
        sql = "UPDATE categoria_productos SET CodCategoria=?, Descripcion=? where CodCategoria = ? or Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
            ps.setString(2, producto.getDescripcionCategoria());
            ps.setString(3, producto.getCodCategoria());
            ps.setString(4, producto.getDescripcionCategoria());

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ExisteCodCategoria(Productos producto) {
        connection = connect.getConnection();
        sql = "select * from categoria_productos "
                + "where CodCategoria=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
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

    public void EliminarCategoria(Productos producto) {
        connection = connect.getConnection();
        sql = "delete from categoria_productos "
                + "where CodCategoria=? and Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
            ps.setString(2, producto.getDescripcionCategoria());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ExisteDescripcionCategoria(Productos producto) {
        connection = connect.getConnection();
        sql = "select * from categoria_productos "
                + "where Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getDescripcionCategoria());
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

    public boolean ExisteCodProducto(Productos producto) {
        connection = connect.getConnection();
        sql = "select * from producto"
                + " where CodProducto=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            return false;
        }
    }
}
