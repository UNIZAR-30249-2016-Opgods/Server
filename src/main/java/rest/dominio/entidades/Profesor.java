package rest.dominio.entidades;

import rest.dominio.objetosvalor.Despacho;

/**
 * Created by phyrion on 12/04/16.
 */
public class Profesor extends Entidad {
    private String nombre;
    private boolean disponibilidad;
    private String info;
    private Despacho despacho;

    public Profesor(){
        super();

    }
}
