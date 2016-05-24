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

    public SimularSeccionesParking() {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        List<SeccionParking> secciones = repo.obtenerSecciones();

        sensores = new ArrayList<>();

        for(SeccionParking seccion : secciones) {
            Sensor sensor = new Sensor();
            sensores.add(sensor);
            sensor.addObserver(seccion);
        }
    }

    /**
     * Bucle indefinido que cada un tiempo entre 5 y 20 segundos rellena o vacia 10 huecos
     * de secciones distintas. Se presupone que cada seccion posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();

            for(int i = 0; i < 10; i++) {
                int queSensor = random.nextInt(sensores.size());
                if(random.nextInt(101) > 49) // 54% probabilidad de ocupar, 46% de liberar
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