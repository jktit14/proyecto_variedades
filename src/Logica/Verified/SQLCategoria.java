package Logica.Verified;

import Logica.SentenciasSQL;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLCategoria {

    Conexion connect = new Conexion();
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null, codCategoria, DescCategoria;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean crearCategoria(Productos producto) {
        //connection = connect.getConnection();
        sql = "Insert into categoria_productos(CodCategoria,Descripcion) "
                + "values (?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
            ps.setString(2, producto.getDescripcionCategoria());
            System.out.println(ps);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ModificarCategoria(Productos producto) {
        //connection = connect.getConnection();
        sql = "UPDATE categoria_productos SET CodCategoria=?, Descripcion=? where CodCategoria = ? and Descripcion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodCategoria());
            ps.setString(2, producto.getDescripcionCategoria());
            ps.setString(3, this.getCodCategoria());
            ps.setString(4, this.getDescCategoria());
            //System.out.println(ps);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void EliminarCategoria(Productos producto) {
        //connection = connect.getConnection();
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

    public boolean ExisteCodCategoria(Productos producto) {
        //connection = connect.getConnection();
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

    public boolean ExisteDescripcionCategoria(Productos producto) {
        //connection = connect.getConnection();
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

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescCategoria() {
        return DescCategoria;
    }

    public void setDescCategoria(String DescCategoria) {
        this.DescCategoria = DescCategoria;
    }

}
