package rest.aplicacion.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesores;

import java.util.List;

@Service("profesorManager")
public class ProfesorManager {

    private RepositorioProfesores repositorioProfesores;

    public void setRepositorioProfesores(RepositorioProfesores repositorioProfesores) {
        this.repositorioProfesores = repositorioProfesores;
    }

    public RepositorioProfesores getRepositorioProfesores() {
        return repositorioProfesores;
    }

    public void addTeacher(Profesor profesor) {
        repositorioProfesores.addTeacher(profesor);
    }

    @Transactional
    public Profesor findById(String id) {
        return repositorioProfesores.findById(id);
    }

    @Transactional
    public List<Profesor> fuzzyFind(String nombre) {
        return repositorioProfesores.fuzzyFind(nombre);
    }

    @Transactional
    public List<Profesor> findAll() {
        return repositorioProfesores.findAll();
    }

    @Transactional
    public Profesor findOne(String id) {
        Profesor profesor = repositorioProfesores.findById(id);
        Profesor profesorDTO = new Profesor(
                profesor.getId(),
                profesor.getNombre(),
                profesor.isDisponibilidad(),
                profesor.getInfo(),
                profesor.getDespacho());

        return profesorDTO;
    }

    @Transactional
    public void cambiarDisponibilidad(String id) {
        repositorioProfesores.modificarDisponibilidad(id);
    }
}
