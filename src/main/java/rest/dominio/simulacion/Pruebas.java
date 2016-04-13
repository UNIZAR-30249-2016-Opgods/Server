package rest.dominio.simulacion;

import rest.dominio.entidades.Profesor;
import rest.dominio.entidades.SeccionParking;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;


public class Pruebas {
    public Pruebas() {
        SeccionParking sp = new SeccionParking("Seccion tal",
                new Punto(1,1,1),
                null, null,
                new Ocupacion(12,1));

        ISensor sensorParking = new Sensor();
        sensorParking.addObserver(sp);
       // sensorParking.salir();
       // sensorParking.salir();

        Profesor profesor = new Profesor("nombre", true, "info", null);
        ISensor sensorProfesor = new Sensor();
        sensorProfesor.addObserver(profesor);
       // sensorProfesor.salir();
       // sensorProfesor.entrar();

    }

}