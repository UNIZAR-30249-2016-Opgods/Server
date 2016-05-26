package rest.aplicacion.simulacion;

import rest.infraestructura.Sensor;
import rest.dominio.profesores.Profesor;
import rest.dominio.profesores.RepositorioProfesoresImpl;

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
            for(int i = 0; i < 10; i++) {
                int queSensor = random.nextInt(sensores.size());
                if (profesores.get(queSensor).isDisponibilidad())
                    cambiarANoDisponible(sensores.get(queSensor));
                else
                    cambiarADisponible(sensores.get(queSensor));
            }
                long waitInMillis = random.nextInt(15000);
            try {
                Thread.sleep(2000+waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    private static void cambiarADisponible(Sensor sensor) { sensor.entrar(); }

    private static void cambiarANoDisponible(Sensor sensor) {
        sensor.salir();
    }

}