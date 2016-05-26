package rest.seccionesparking;

import rest.common.Punto;

import java.util.List;

public interface RepositorioSeccionParking {

    List<SeccionParking> obtenerSecciones();

    boolean actualizarParking(SeccionParking parking) throws Exception;

    List<Punto> obtenerPuntosAcceso();

}
