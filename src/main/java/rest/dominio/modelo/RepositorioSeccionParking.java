package rest.dominio.modelo;

import rest.dominio.entidades.SeccionParking;

import java.util.List;

/**
 * Created by Mario on 13/04/2016.
 */
public interface RepositorioSeccionParking {

    List<SeccionParking> obtenerSecciones();

    void ocuparPlaza(String id) throws Exception;

    void liberarPlaza(String id) throws Exception;

    SeccionParking findById(String id);

    void addSeccionParking(SeccionParking seccionParking);

}
