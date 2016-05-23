package rest.cafeterias;

import rest.common.Entidad;
import rest.common.Ocupacion;
import rest.common.Punto;

/**
 * Created by phyrion on 23/05/16.
 */
public class Cafeteria extends Entidad {
    private String nombre;
    private Punto punto;
    private Ocupacion ocupacion;

    public Cafeteria(String nombre, Punto punto, Ocupacion ocupacion) {
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public Cafeteria(String id, String nombre, Punto punto, Ocupacion ocupacion) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }
}
