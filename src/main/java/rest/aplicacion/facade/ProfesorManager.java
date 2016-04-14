package rest.aplicacion.facade;

import org.springframework.transaction.annotation.Transactional;
import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesores;
import rest.infraestructura.BBDD.ProfesorDTO;

/**
 * Created by Mario on 13/04/2016.
 */
public class ProfesorManager {

    private RepositorioProfesores repositorioProfesores;

    public void setRepositorioProfesores(RepositorioProfesores repositorioProfesores) {
        this.repositorioProfesores = repositorioProfesores;
    }

    public RepositorioProfesores getRepositorioProfesores() {
        return repositorioProfesores;
    }

    @Transactional
    public void addTeacher(ProfesorDTO profesor) {
        getRepositorioProfesores().addTeacher(profesor);

    }
    @Transactional
    public ProfesorDTO findOne(String id) {
        ProfesorDTO profesor = getRepositorioProfesores().findOne(id);
        ProfesorDTO profesorDTO = new ProfesorDTO(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getDisponibilidad(),
                profesor.getInfo());

        return profesorDTO;
    }
}
