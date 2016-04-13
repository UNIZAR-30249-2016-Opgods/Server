package rest.models;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Singleton que proporciona instancia del SessionFactory.
 * Al ser pesado, interesa que solo se cree una vez.
 *
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crea el SessionFactory desde hibernate.cfg.xml
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
     * Obtiene la sesion previamente creada. Si <test> es verdad crea una nueva sesion
     * con la configuracion para los test.
     * @param test
     * @return
     */
    public static SessionFactory getSessionFactory(boolean test) {
        if (test)
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.test.xml").buildSessionFactory();
        return sessionFactory;
    }

    /**
     * Cierra la sesion.
     */
    public static void shutdown() {
        sessionFactory.close();
    }
}