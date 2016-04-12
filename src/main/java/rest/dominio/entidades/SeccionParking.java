package rest.dominio.entidades;

import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by phyrion on 12/04/16.
 */
public class SeccionParking extends Entidad implements Observer{

    private String nombre;
    private Punto punto;
    private Ruta[] rutas = new Ruta[2];
    private Ocupacion ocupacion;

    public SeccionParking(String nombre, Punto punto, Ruta ruta1, Ruta ruta2, Ocupacion ocupacion) {
        this.nombre = nombre;
        this.punto = punto;
        this.rutas[0] = ruta1;
        this.rutas[1] = ruta2;
        this.ocupacion = ocupacion;
    }

    public SeccionParking(String id, String nombre, Punto punto, Ruta ruta1, Ruta ruta2, Ocupacion ocupacion) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.rutas[0] = ruta1;
        this.rutas[1] = ruta2;
        this.ocupacion = ocupacion;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
