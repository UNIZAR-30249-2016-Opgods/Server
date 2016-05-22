package rest.aplicacion.simulacion;

import rest.dominio.entidades.SeccionParking;
import rest.dominio.objetosvalor.AccesoParking;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;

import java.util.ArrayList;
import java.util.Random;

public class SimularParking implements Runnable{

    ISensor sensorParking1;
    ISensor sensorParking2;
    ArrayList<ISensor> sensores;

    public SimularParking() {
        Punto puntoRuta1 = new Punto(1,1,1);
        Punto puntoRuta2 = new Punto(2,2,2);
        Punto puntoParking = new Punto(3,3,3);
        AccesoParking ap1 = new AccesoParking(puntoRuta1, 1);
        AccesoParking ap2 = new AccesoParking(puntoRuta2, 2);
        Ocupacion ocupacion = new Ocupacion(12, 0);
        SeccionParking sp1 = crearSeccionParking("Seccion1", puntoParking, ocupacion);

        puntoRuta1 = new Punto(1,1,1);
        puntoRuta2 = new Punto(2,2,2);
        puntoParking = new Punto(3,3,3);
        ap1 = new AccesoParking(puntoRuta1, 1);
        ap2 = new AccesoParking(puntoRuta2, 2);

        ocupacion = new Ocupacion(12, 0);
        SeccionParking sp2 = crearSeccionParking("Seccion2", puntoParking, ocupacion);

        sensores = new ArrayList<>();

        sensorParking1 = new Sensor();
        sensores.add(sensorParking1);
        sensorParking1.addObserver(sp1);

        sensorParking2 = new Sensor();
        sensores.add(sensorParking2);
        sensorParking2.addObserver(sp2);
    }

    /**
     * Bucle indefinido que cada un tiempo entre 0 y 1 segundo [añade, libera] un coche de
     * una sección específica. Se presupone que cada sección posee un sensor distinto.
     */
    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            int opcion = random.nextInt(2);
            int queSensor = random.nextInt(sensores.size());
            if(opcion == 0)
                llenarPlaza(sensores.get(queSensor));
            else
                liberarPlaza(sensores.get(queSensor));


            long waitInMillis = random.nextInt(2000);
            try {
                Thread.sleep(waitInMillis);
            } catch (InterruptedException e) {
                System.err.println("Error durante la simulación: " + e.getMessage());
            }
        }
    }

    private void llenarPlaza(ISensor sensor){
        sensor.entrar();
    }

    private void liberarPlaza(ISensor sensor){
        sensor.salir();
    }

    private SeccionParking crearSeccionParking(String nombre, Punto punto, Ocupacion ocupacion) {
        return new SeccionParking(nombre, punto, ocupacion);
    }

}
