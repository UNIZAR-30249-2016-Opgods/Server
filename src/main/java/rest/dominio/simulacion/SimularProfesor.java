package rest.dominio.simulacion;

import rest.dominio.entidades.Profesor;
import rest.dominio.objetosvalor.*;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;

import java.util.ArrayList;
import java.util.Random;

public class SimularProfesor implements Runnable{

    ISensor sensorProfesor1;
    ISensor sensorProfesor2;
    ArrayList<ISensor> sensores;

    public SimularProfesor() {
        Punto punto = new Punto(1,1,1);
        Localizacion localizacion = new Localizacion(punto, 1, 1);
        Despacho despacho = new Despacho(localizacion, "331231");
        Profesor profesor1 = new Profesor("Mariano", false, "profesor op", despacho);

        punto = new Punto(1,1,1);
        localizacion = new Localizacion(punto, 1, 1);
        despacho = new Despacho(localizacion, "331231");
        Profesor profesor2 = new Profesor("Paco", false, "profesor no op", despacho);


        sensores = new ArrayList<>();

        sensorProfesor1 = new Sensor();
        sensores.add(sensorProfesor1);
        sensorProfesor1.addObserver(profesor1);

        sensorProfesor2 = new Sensor();
        sensores.add(sensorProfesor2);
        sensorProfesor2.addObserver(profesor2);
    }

    /**
     * Bucle indefinido que cada un tiempo entre 0 y 5 segundo cambia la disponibilidad
     * de un profesor. Se presupone que cada profesor posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            int queSensor = random.nextInt(sensores.size());
            int opcion = random.nextInt(2);

            if(opcion == 0)
                cambiarADisponible(sensores.get(queSensor));
            else
                cambiarANoDisponible(sensores.get(queSensor));


            long waitInMillis = random.nextInt(5000);
            try {
                Thread.sleep(waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    private void cambiarADisponible(ISensor sensor) {
        sensor.entrar();
    }

    private void cambiarANoDisponible(ISensor sensor) {
        sensor.salir();
    }


}
