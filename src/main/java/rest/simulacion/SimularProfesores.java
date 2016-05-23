package rest.simulacion;

import rest.common.Sensor;
import rest.profesores.Profesor;
import rest.profesores.RepositorioProfesoresImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimularProfesores implements Runnable{

    private static ArrayList<Sensor> sensores;
    private static List<Profesor> profesores;

    public SimularProfesores() {
        RepositorioProfesoresImpl repositorioProfesores = new RepositorioProfesoresImpl();
        profesores = repositorioProfesores.findAll();

        sensores = new ArrayList<>();

        for(Profesor profesor : profesores) {
            Sensor sensor = new Sensor();
            sensores.add(sensor);
            sensor.addObserver(profesor);
        }
    }

    /**
     * Bucle indefinido que cada un tiempo entre 2 y 517 segundo cambia la disponibilidad
     * de un profesor. Se presupone que cada profesor posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            int queSensor = random.nextInt(sensores.size());

            if(profesores.get(queSensor).isDisponibilidad())
                cambiarANoDisponible(sensores.get(queSensor));
            else
                cambiarADisponible(sensores.get(queSensor));

            long waitInMillis = random.nextInt(15000);
            try {
                Thread.sleep(2000+waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    public static void cambiarADisponible(Sensor sensor) { sensor.entrar(); }

    public static void cambiarANoDisponible(Sensor sensor) {
        sensor.salir();
    }


}