package rest.infraestructura.BBDD;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton que proporciona instancia del SessionFactory.
 * Al ser pesado, interesa que solo se cree una vez.
 *
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static Connection connection = null;

    private static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = HibernateUtils.class.getClassLoader().getResourceAsStream("application.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("spring.datasource.driver-class-name");
                String url = prop.getProperty("spring.datasource.url");
                String user = prop.getProperty("spring.datasource.username");
                String password = prop.getProperty("spring.datasource.password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion exitosa.");
            } catch (ClassNotFoundException | SQLException | IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            return connection;
        }
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Obtiene la sesion previamente creada.
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra la sesion.
     */
    public static void shutdown() {
        sessionFactory.close();
    }

/*
    public static void main(String[] args) {
        Connection conn = getConnection();
        Preparar();

    }
    public static void Preparar() {
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("CREATE TABLE PROFESOR(" +
                            "id VARCHAR(100) NOT NULL UNIQUE," +
                            "nombre VARCHAR(100) NOT NULL," +
                            "disponibilidad CHAR(1) NOT NULL," +
                            "info VARCHAR(100) NOT NULL," +
                            "PRIMARY KEY(id))");

            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement = connection
                    .prepareStatement("CREATE TABLE SECCIONPARKING(" +
                            "id VARCHAR(100) NOT NULL UNIQUE," +
                            "nombre VARCHAR(100) NOT NULL," +
                            "PRIMARY KEY(id))");

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
*/
}
