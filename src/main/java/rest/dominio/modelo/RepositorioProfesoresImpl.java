package rest.dominio.modelo;

import rest.dominio.entidades.Profesor;

import java.util.List;

public class RepositorioProfesoresImpl implements RepositorioProfesores {


    @Override
    public void addTeacher(Profesor profesor) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(profesor);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }

    @Override
    public Profesor findById(String id) {
//        Profesor profesor;
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Profesor.class).add(Restrictions.eq("id", id));
//        profesor = (Profesor) criteria.uniqueResult();
//        session.flush();
//        session.close();

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> fuzzyFind(String nombre) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Profesor.class).add(Restrictions.eq("nombre", nombre));
//        List<Profesor> teachers = (List<Profesor>) criteria.list();
//        session.flush();
//        session.close();

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> findAll() {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Profesor.class);
//        List<Profesor> teachers = (List<Profesor>) criteria.list();
//        session.flush();
//        session.close();

        return null;
    }

    @Override
    public List<Profesor> findFloor(int UTCplanta) {
        return null;
    }

    @Override
    public void modificarDisponibilidad(String id) {
        Profesor profesor = findById(id);
        if (profesor != null) {
            boolean disponibilidad = !profesor.isDisponibilidad();
            Profesor profesorAct = new Profesor(
                    profesor.getId(),
                    profesor.getNombre(),
                    disponibilidad,
                    profesor.getInfo()
                    );

//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.update(profesorAct);
//            session.getTransaction().commit();
//            session.flush();
//            session.close();
        }
    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
}