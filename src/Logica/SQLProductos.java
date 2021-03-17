package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLProductos {

    Conexion connect = new Conexion();
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean ExisteCodProducto(Productos producto) {
        connection = connect.getConection();
        sql = "select * from producto "
                + "where CodProducto=?";
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
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String ObtenerCodCategoria(Productos producto) {
        String Categoria;
        connection = connect.getConection();
        sql = "select * from categoria_productos "
                + "where Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getDescripcionCategoria());
            rs = ps.executeQuery();
            if (rs.next()) {
                Categoria = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "Categoria No Existe");
                Categoria = "No Existe";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return Categoria;
    }

    public boolean crearProducto(Productos producto) {
        connection = connect.getConection();
        sql = "Insert into producto(CodProducto,Descripcion, CodCategoria) "
                + "values (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCodCategoria());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
