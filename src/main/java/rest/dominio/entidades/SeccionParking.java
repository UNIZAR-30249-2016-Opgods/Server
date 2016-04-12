package rest.dominio.entidades;

import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;

/**
 * Created by phyrion on 12/04/16.
 */
public class SeccionParking extends Entidad {
    private String nombre;
    private Punto punto;
    private Ruta[] rutas = new Ruta[2];
}
