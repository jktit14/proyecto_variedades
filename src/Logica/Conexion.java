package Logica;

//Esta clase es la que permitira la conexion con la Base de Datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //private static Connection connect;
    //private static final String Driver = "com.mysql.jdbc.Driver";
    //private static final String User = "eyballesterosp";
    //private static final String Password = "1509Y3$1d";
    //private static final String Url = "jdbc:mysql://192.168.20.200:3306/fact_variedades";
    private static Connection connect;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String User = "h5UWGvy0uD";
    private static final String Password = "7hLs5NOPwV";
    private static final String Url = "jdbc:mysql://remotemysql.com/h5UWGvy0uD";

    public Conexion() {
        getConnection();
    }

    //Metodo para establecer la conexion a la base de datos
    public Connection getConnection() {
        try {
            Class.forName(Driver);
            connect = DriverManager.getConnection(Url, User, Password);
            if (connect != null) {
                //System.out.println("Conexion Exitosa...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            //System.out.println("Conexion Fallida!!!\n" + e);
            this.getConnection();
            System.out.println("Error de Prueba: " + e);
        }
        return connect;
    }

    //Metodo para cerrar la conexion a la base de datos
    public void stopConection() {
        connect = null;
        if (connect == null) {
            System.out.println("Se ha desconectado de la Base de Datos");
        }
    }

}
