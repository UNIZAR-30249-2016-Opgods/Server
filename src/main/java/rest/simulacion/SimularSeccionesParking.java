package rest.simulacion;

import rest.common.Sensor;
import rest.profesores.Profesor;
import rest.profesores.RepositorioProfesoresImpl;
import rest.seccionesparking.RepositorioSeccionParkingImpl;
import rest.seccionesparking.SeccionParking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimularSeccionesParking implements Runnable{

    private static ArrayList<Sensor> sensores;
    private static List<SeccionParking> secciones;

    public SimularSeccionesParking() {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        secciones = repo.obtenerSecciones();

        sensores = new ArrayList<>();

        for(SeccionParking seccion : secciones) {
            Sensor sensor = new Sensor();
            sensores.add(sensor);
            sensor.addObserver(seccion);
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

            for(int i = 0; i < 10; i++) {
                int queSensor = random.nextInt(sensores.size());
                if(random.nextInt(11) > 5)
                    ocuparPlaza(sensores.get(queSensor));
                else
                    liberarPlaza(sensores.get(queSensor));
            }

            long waitInMillis = random.nextInt(15000);
            try {
                Thread.sleep(5000+waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    public static void ocuparPlaza(Sensor sensor) { sensor.entrar(); }

    public static void liberarPlaza(Sensor sensor) {
        sensor.salir();
    }


}