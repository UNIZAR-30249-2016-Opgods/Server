package rest.dominio.modelo;

import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.List;

/**
 * Created by Mario on 13/04/2016.
 */
public interface RepositorioProfesores {

    void addTeacher(ProfesorDTO profesor);

    ProfesorDTO findById(String id);

    List<ProfesorDTO> fuzzyFind(String nombre);

    List<ProfesorDTO> findAll();

    List<ProfesorDTO> findFloor(int UTCplanta);

    void modificarDisponibilidad(String id);

}
