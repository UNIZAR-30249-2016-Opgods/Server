package rest.dominio.entidades;

import org.hibernate.annotations.Type;
import rest.dominio.objetosvalor.Despacho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Observable;
import java.util.Observer;


@Table(name="PROFESOR")
public class Profesor extends Entidad implements Observer {
    @Column(name="nombre", unique = false, nullable = false)
    private String nombre;
    @Column(name="disponibilidad", unique = false, nullable = false, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean disponibilidad;
    @Column(name="info", unique = false, nullable = false)
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
