package rest.dominio.modelo;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import rest.dominio.entidades.Profesor;
import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.ArrayList;

@Repository
public class RepositorioProfesoresImpl implements RepositorioProfesores {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void addTeacher(ProfesorDTO profesor) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
        session.flush();
    }

    @Override
    public ProfesorDTO findOne(String id) {
        ProfesorDTO profesor = null;
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProfesorDTO.class).add(Restrictions.eq("id", id));
        profesor = (ProfesorDTO) criteria.uniqueResult();
        session.flush();

        return profesor;
    }

    @Override
    public ArrayList<ProfesorDTO> fuzzyFind(String nombre) {
        return null;
    }

    @Override
    public ArrayList<ProfesorDTO> findAll() {
        return null;
    }

    @Override
    public ArrayList<ProfesorDTO> findFloor(int UTCplanta) {
        return null;
    }

    @Override
    public void modificarDisponibilidad(String id) {

    }
}
