package rest.cafeterias;

import rest.common.Punto;
import rest.seccionesparking.SeccionParking;

import java.util.List;

/**
 * Created by Mario on 13/04/2016.
 */
public interface RepositorioCafeterias {

    List<Cafeteria> obtenerCafeterias();

    void ocuparPlaza(String id) throws Exception;

    void liberarPlaza(String id) throws Exception;

    SeccionParking findById(String id);

}
