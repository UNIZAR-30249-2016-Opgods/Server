package rest.dominio.entidades;

import rest.dominio.objetosvalor.Despacho;

import java.util.Observable;
import java.util.Observer;

public class Profesor extends Entidad implements Observer {
    private String nombre;
    private boolean disponibilidad;
    private String info;
    private Despacho despacho;

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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public String getInfo() {
        return info;
    }

    public Despacho getDespacho() {
        return despacho;
    }

    @Override
    //TODO: Cambiar try catch por throws. Esto es solo para probar
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        if (actualizar.contains("ENTRAR")) {
            disponibilidad = true;
            System.out.println("El profesor [" + nombre + "] está disponible.");
        } else {
            disponibilidad = false;
            System.out.println("El profesor [" + nombre + "] está ocupado.");
        }
    }

}
