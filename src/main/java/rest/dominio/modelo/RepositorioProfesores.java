package rest.dominio.modelo;

import rest.dominio.entidades.Profesor;

import java.util.List;

/**
 * Created by Mario on 13/04/2016.
 */
public interface RepositorioProfesores {

    List<Profesor> fuzzyFind(String nombre);

    List<Profesor> findFloor(int UTCplanta);

    void modificarDisponibilidad(String id);

}
