package rest.dominio.modelo;

import rest.dominio.entidades.SeccionParking;

import java.util.List;

//@Repository("repositorioSeccionParking")
public class RepositorioSeccionParkingImpl implements RepositorioSeccionParking {

//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    @Override
    public void addSeccionParking(SeccionParking seccionParking) {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(seccionParking);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();

    }

    @Override
    public SeccionParking findById(String id) {
//        SeccionParking seccionParking;
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(SeccionParking.class).add(Restrictions.eq("id", id));
//        seccionParking = (SeccionParking) criteria.uniqueResult();
//        session.flush();
//        session.close();

        return null;
    }


    @Override
    public List<SeccionParking> obtenerSecciones() {
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(SeccionParking.class);
//        List<SeccionParking> teachers = (List<SeccionParking>) criteria.list();
//        session.flush();
//        session.close();

        return null;
    }

    @Override
    public void ocuparPlaza(String id) throws Exception {
//        SeccionParking seccionParking = findById(id);
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        seccionParking.ocuparPlaza();
//        session.update(seccionParking);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }

    @Override
    public void liberarPlaza(String id) throws Exception {
//        SeccionParking seccionParking = findById(id);
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        seccionParking.liberarPlaza();
//        session.update(seccionParking);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }
}