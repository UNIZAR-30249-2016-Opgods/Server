package rest.dominio.modelo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.List;

@Repository("repositorioProfesores")
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
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(profesor);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public ProfesorDTO findById(String id) {
        ProfesorDTO profesor;
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProfesorDTO.class).add(Restrictions.eq("id", id));
        profesor = (ProfesorDTO) criteria.uniqueResult();
        session.flush();
        session.close();

        return profesor;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProfesorDTO> fuzzyFind(String nombre) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProfesorDTO.class).add(Restrictions.eq("nombre", nombre));
        List<ProfesorDTO> teachers = (List<ProfesorDTO>) criteria.list();
        session.flush();
        session.close();

        return teachers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProfesorDTO> findAll() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProfesorDTO.class);
        List<ProfesorDTO> teachers = (List<ProfesorDTO>) criteria.list();
        session.flush();
        session.close();

        return teachers;
    }

    @Override
    public List<ProfesorDTO> findFloor(int UTCplanta) {
        return null;
    }

    @Override
    public void modificarDisponibilidad(String id) {
        ProfesorDTO profesor = findById(id);
        if (profesor != null) {
            boolean disponibilidad = !profesor.getDisponibilidad();
            ProfesorDTO profesorAct = new ProfesorDTO(
                    profesor.getId(),
                    profesor.getNombre(),
                    disponibilidad,
                    profesor.getInfo());

            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.update(profesorAct);
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
    }

}