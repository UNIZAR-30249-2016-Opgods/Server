package rest.common;

/**
 * Created by phyrion on 21/05/16.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBBDD {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String HOST = "jdbc:postgresql://geoserver.cuobtic26knt.eu-west-1.rds.amazonaws.com:5432/proyectodb?sslmode=require";
    private static final String USER = "labis";
    private static final String PASSWORD = "geoserver";
    static Connection conexion = null;

    public static Connection conectar(){
        if (conexion == null) {
            try {
                Class.forName(DRIVER);
                conexion = DriverManager
                        .getConnection(HOST,
                                       USER,
                                       PASSWORD);
                if (conexion != null) {
                    System.out.println("Conexión a base de datos  ... Ok");
                    return conexion;
                    //conexion.close();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } else {
            return conexion;
        }

    }

    public static void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {

        }
    }

}