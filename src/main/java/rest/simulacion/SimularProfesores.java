package rest.simulacion;

import rest.common.Sensor;
import rest.profesores.Profesor;
import rest.profesores.RepositorioProfesoresImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimularProfesores implements Runnable{

    private static ArrayList<Sensor> sensores;
    private static List<Profesor> profesorList;

    public SimularProfesores() {
        RepositorioProfesoresImpl repositorioProfesores = new RepositorioProfesoresImpl();
        profesorList = repositorioProfesores.findAll();

        sensores = new ArrayList<>();

        for(Profesor profesor : profesorList) {
            Sensor sensor = new Sensor();
            sensores.add(sensor);
            sensor.addObserver(profesor);
        }
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

            if(profesorList.get(queSensor).isDisponibilidad())
                cambiarANoDisponible(sensores.get(queSensor));
            else
                cambiarADisponible(sensores.get(queSensor));

            long waitInMillis = random.nextInt(1000);
            try {
                Thread.sleep(waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    public static List<Profesor> obtenerListaProfesores() {
        return profesorList;
    }

    public static List<Sensor> obtenerListaSensores() { return sensores; }

    public static void cambiarADisponible(Sensor sensor) {
        sensor.entrar();
    }

    public static void cambiarANoDisponible(Sensor sensor) {
        sensor.salir();
    }


}