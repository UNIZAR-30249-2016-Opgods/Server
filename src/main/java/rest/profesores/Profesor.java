package rest.profesores;

import rest.common.Entidad;
import rest.seccionesparking.RepositorioSeccionParking;

import java.util.Observable;
import java.util.Observer;

public class Profesor extends Entidad implements Observer, Comparable {

    private String nombre;
    private boolean disponibilidad;
    private String info;
    private Despacho despacho;

    // Para inserciones en BBDD y JSON
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
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        if (actualizar.contains("ENTRAR")) {
            disponibilidad = true;
           // System.out.println("El profesor [" + nombre + "] está disponible.");
        } else {
            disponibilidad = false;
           // System.out.println("El profesor [" + nombre + "] está ocupado.");
        }
        // Llama al repositorio para modificar la disponibilidad
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        repo.modificarDisponibilidad(getId());
    }

    @Override
    public int compareTo(Object o) {
        return this.getId().compareTo(((Profesor) o).getId());
//        int comparacion = Integer.parseInt(((Profesor) o).getId());
//        return Integer.parseInt(this.getId())-comparacion;
    }
}
