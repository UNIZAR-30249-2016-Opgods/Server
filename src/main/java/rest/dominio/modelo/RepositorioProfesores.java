package rest.dominio.modelo;

import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.ArrayList;

/**
 * Created by Mario on 13/04/2016.
 */
public interface RepositorioProfesores {

    void addTeacher(ProfesorDTO profesor);

    ProfesorDTO findOne(String id);

    ArrayList<ProfesorDTO> fuzzyFind(String nombre);

    ArrayList<ProfesorDTO> findAll();

    ArrayList<ProfesorDTO> findFloor(int UTCplanta);

    void modificarDisponibilidad(String id);

}
