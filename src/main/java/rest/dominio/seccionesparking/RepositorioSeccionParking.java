package rest.dominio.seccionesparking;

import rest.dominio.common.Punto;

import java.util.List;

public interface RepositorioSeccionParking {

    List<SeccionParking> obtenerSecciones();

    boolean actualizarParking(SeccionParking parking) throws Exception;

    List<Punto> obtenerPuntosAcceso();

}
