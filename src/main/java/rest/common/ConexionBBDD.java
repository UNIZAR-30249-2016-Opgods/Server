package rest.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que facilita la conexión con la base de datos
 */
public class ConexionBBDD {

    static Connection conexion = null;

    public static Connection conectar(){
        if (conexion == null) {
            try {
                Class.forName(Constantes.DRIVER);
                conexion = DriverManager
                        .getConnection(Constantes.HOST,
                                        Constantes.USER,
                                        Constantes.PASSWORD);
                if (conexion != null) {
                    System.out.println("Conexión a base de datos  ... Ok");
                    return conexion;
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } else {
            return conexion;
        }

    }

    /**
     * Método que cierra la conexión con la base de datos
     */
    public static void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}