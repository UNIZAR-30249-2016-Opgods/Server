package rest.simulacion;

import rest.cafeterias.Cafeteria;
import rest.cafeterias.RepositorioCafeteriasImpl;
import rest.common.Sensor;
import rest.seccionesparking.RepositorioSeccionParkingImpl;
import rest.seccionesparking.SeccionParking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimularCafeterias implements Runnable{

    private static ArrayList<Sensor> sensores;

    public SimularCafeterias() {
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();
        List<Cafeteria> cafeterias = repo.obtenerCafeterias();

        sensores = new ArrayList<>();

        for(Cafeteria cafeteria : cafeterias) {
            Sensor sensor = new Sensor();
            sensores.add(sensor);
            sensor.addObserver(cafeteria);
        }
    }

    /**
     * Bucle indefinido que cada un tiempo entre 5 y 20 segundos rellena o vacia 10 huecos
     * de cafeterias distintas. Se presupone que cada cafeteria posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();

            for(int i = 0; i < 10; i++) {
                int queSensor = random.nextInt(sensores.size());
                if(random.nextInt(101) > 49) // 51% probabilidad de ocupar, 49% de liberar
                    ocuparCafeteria(sensores.get(queSensor));
                else
                    liberarCafeteria(sensores.get(queSensor));
            }

            long waitInMillis = random.nextInt(15000);
            try {
                Thread.sleep(5000+waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    public static void ocuparCafeteria(Sensor sensor) { sensor.entrar(); }

    public static void liberarCafeteria(Sensor sensor) {
        sensor.salir();
    }

}