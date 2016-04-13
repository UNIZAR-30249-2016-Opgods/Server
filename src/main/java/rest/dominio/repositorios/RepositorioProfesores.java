package rest.dominio.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rest.dominio.entidades.Profesor;


public class RepositorioProfesores {

    @Autowired
    private SessionFactory sessionFactory;

    public Profesor findOne(int objID) {
        return (Profesor) sessionFactory.getCurrentSession().get(Profesor.class, objID);
    }

}
