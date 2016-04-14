package rest.dominio.modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.ArrayList;

/**
 * Created by Mario on 14/04/2016.
 */

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
        session.save(profesor);
    }

    @Override
    public ProfesorDTO findOne(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        ProfesorDTO profesor = (ProfesorDTO) session.load(ProfesorDTO.class, id);
        return profesor;
    }

  /*
    @Override
    public Profesor findOne(String id) {
        return (Profesor) getSessionFactory()
                .openSession().
                createQuery("from PROFESOR where id = :id").
                setParameter("id", id).
                uniqueResult();
    }*/

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
