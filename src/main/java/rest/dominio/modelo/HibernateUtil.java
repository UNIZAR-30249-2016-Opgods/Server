package rest.dominio.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static Connection connection = null;

    private static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties");
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

}