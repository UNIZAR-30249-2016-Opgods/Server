package rest.dominio.entidades;

import rest.dominio.objetosvalor.Despacho;

import java.util.Observable;
import java.util.Observer;

public class Profesor extends Entidad {

    private String nombre;
    private boolean disponibilidad;
    private String info;
    private Despacho despacho;

    // Para inserciones en BBDD
    public Profesor(String id, String nombre, boolean disponibilidad, String info) {
        super(id);
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.info = info;
    }

    public Profesor(String nombre, boolean disponibilidad, String info, Despacho despacho) {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.info = info;
        this.despacho = despacho;
    }

    public Profesor(String id, String nombre, boolean disponibilidad, String info, Despacho despacho) {
        super(id);
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.info = info;
        this.despacho = despacho;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAvailable() { return disponibilidad; }

    public String getInfo() {
        return info;
    }

    public Despacho getDespacho() {
        return despacho;
    }

}
