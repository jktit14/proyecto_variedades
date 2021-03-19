package Logica;

import Logica.Verified.Productos;
import Logica.Verified.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLProductos {

    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null, codProducto, DescProducto, codCategoria, DesCategoria;
    Conexion connect = new Conexion();
    Connection connection = null;

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescProducto() {
        return DescProducto;
    }

    public void setDescProducto(String DescProcuto) {
        this.DescProducto = DescProcuto;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDesCategoria() {
        return DesCategoria;
    }

    public void setDesCategoria(String DesCategoria) {
        this.DesCategoria = DesCategoria;
    }


    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean ExisteCodProducto(Productos producto) {
        // connection = connect.getConnection();
        sql = "select * from producto"
                + " where CodProducto=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            rs = ps.executeQuery();
            if (rs.next()) {
                //System.out.println("OK");
                //connect.stopConection();
                return true;
            } else {
                //System.out.println("Error");
                //connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            //connect.stopConection();
            return false;
        }
    }

    public boolean ExisteProducto(Productos producto) {
        //connection = connect.getConnection();
        sql = "select * from producto"
                + " where CodProducto=? and Descripcion=? and CodCategoria=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCodCategoria());
            //System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                //connect.stopConection();
                return true;
            } else {
                //connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            //connect.stopConection();
            return false;
        }
    }

    public boolean ExisteDescripcionProducto(Productos producto) {
        //connection = connect.getConnection();
        sql = "select * from producto "
                + "where Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            rs = ps.executeQuery();
            if (rs.next()) {
                //connect.stopConection();
                return true;
            } else {
                //connect.stopConection();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            //connect.stopConection();
            return false;
        }
    }

    public String ObtenerCodCategoria(String cadena) {
        //connection = connect.getConnection();
        String Categoria;

        sql = "select * from categoria_productos "
                + "where Descripcion=?";
        try {
            ps = connection.prepareStatement(sql.toString());
            ps.setString(1, cadena);
            rs = ps.executeQuery();
            if (rs.next()) {
                Categoria = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "La Categoria " + cadena + "No Existe");
                Categoria = "No Existe";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        //connect.stopConection();
        return Categoria;
    }

    public boolean crearProducto(Productos producto) {
        //connection = connect.getConnection();
        String sql1 = "Insert into producto(CodProducto,Descripcion, CodCategoria) "
                + "values (?,?,?)";
        try {
            ps = connection.prepareStatement(sql1);

            ps.setString(1, producto.getCodProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCodCategoria());
            ps.execute();
            //connect.stopConection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            //connect.stopConection();
            return false;
        }
    }

    public boolean ModificarProducto(Productos producto) {
        //connection = connect.getConnection();
        sql = "UPDATE producto SET CodProducto=?, Descripcion=?,CodCategoria=? "
                + "where CodProducto = ? and Descripcion=? and CodCategoria=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCodCategoria());
            ps.setString(4, this.getCodProducto());
            ps.setString(5, this.getDescProducto());
            ps.setString(6, this.getCodCategoria());
            //System.out.println(ps);
            ps.execute();
            //connect.stopConection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            //connect.stopConection();
            return false;
        }
    }
}
