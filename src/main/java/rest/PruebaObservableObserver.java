package rest;

import rest.dominio.entidades.SeccionParking;
import rest.dominio.objetosvalor.AccesoParking;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;
import rest.infraestructura.Sensor;

/**
 * Created by Mario on 13/4/16.
 */
public class PruebaObservableObserver {
    public static void main(String[] args) {
        Punto punto = new Punto(1, 1.5, 1.6);
        AccesoParking ap = new AccesoParking(punto, 1);
        Ruta ruta1 = new Ruta(1, ap);
        Ruta ruta2 = new Ruta(2, ap);
        Ocupacion ocupacion = new Ocupacion(50, 10);

        //Observador
        SeccionParking sp = new SeccionParking("seccion1", punto, ruta1, ruta2, ocupacion);
        //Observado
        Sensor sensor = new Sensor(0, 0);

        sensor.addObserver(sp);

        sensor.entrar(10);
    }
}
