package rest.aplicacion.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesores;
import rest.infraestructura.BBDD.ProfesorDTO;

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

    public void addTeacher(ProfesorDTO profesor) {
        repositorioProfesores.addTeacher(profesor);
    }

    @Transactional
    public ProfesorDTO findById(String id) {
        return repositorioProfesores.findById(id);
    }

    @Transactional
    public List<ProfesorDTO> fuzzyFind(String nombre) {
        return repositorioProfesores.fuzzyFind(nombre);
    }

    @Transactional
    public List<ProfesorDTO> findAll() {
        return repositorioProfesores.findAll();
    }

    @Transactional
    public ProfesorDTO findOne(String id) {
        ProfesorDTO profesor = repositorioProfesores.findById(id);
        ProfesorDTO profesorDTO = new ProfesorDTO(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getDisponibilidad(),
                profesor.getInfo());

        return profesorDTO;
    }

    @Transactional
    public void cambiarDisponibilidad(String id) {
        repositorioProfesores.modificarDisponibilidad(id);
    }
}
