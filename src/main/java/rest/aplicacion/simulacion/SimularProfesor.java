package rest.aplicacion.simulacion;

import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesoresImpl;
import rest.dominio.objetosvalor.*;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimularProfesor implements Runnable{

    ArrayList<ISensor> sensores;
    RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();

    public SimularProfesor() {

        List<Profesor> profesorList = repo.fuzzyFind("");

        sensores = new ArrayList<>();
        for(Profesor profesor : profesorList) {
            ISensor s = new Sensor();
            sensores.add(s);
            s.addObserver(profesor);
        }
    }

    /**
     * Bucle indefinido que cada un tiempo entre 0 y 2 segundos cambia la disponibilidad
     * de un profesor. Se presupone que cada profesor posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            int queSensor = random.nextInt(sensores.size());

            cambiarADisponible(sensores.get(queSensor));
            repo.modificarDisponibilidad(Integer.toString(queSensor));

            long waitInMillis = random.nextInt(2000);
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
