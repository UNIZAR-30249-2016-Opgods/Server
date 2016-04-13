package rest.dominio.simulacion;

import rest.dominio.entidades.SeccionParking;
import rest.dominio.objetosvalor.AccesoParking;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mario on 13/4/16.
 */
public class SimularParking implements Runnable{

    ISensor sensorParking1;
    ISensor sensorParking2;
    ArrayList<ISensor> sensores;

    public SimularParking() {
        Punto punto1 = new Punto(1,1,1);
        Punto punto2 = new Punto(2,2,2);
        Ruta ruta1 = new Ruta(1, new AccesoParking(punto1, 1));
        Ruta ruta2 = new Ruta(2, new AccesoParking(punto2, 2));
        Ruta[] rutas1 = {ruta1, ruta2};
        SeccionParking sp1 = crearSeccionParking("Seccion1", new Punto(1,1,1), rutas1, new Ocupacion(12,0));

        punto1 = new Punto(3,3,3);
        punto2 = new Punto(4,4,4);
        ruta1 = new Ruta(1, new AccesoParking(punto1, 1));
        ruta2 = new Ruta(2, new AccesoParking(punto2, 2));
        Ruta[] rutas2 = {ruta1, ruta2};
        SeccionParking sp2 = crearSeccionParking("Seccion2", new Punto(1,1,1), rutas2, new Ocupacion(15,0));

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

    public void llenarPlaza(ISensor sensor){
        sensor.entrar();
    }

    public void liberarPlaza(ISensor sensor){
        sensor.salir();
    }

    private SeccionParking crearSeccionParking(String nombre, Punto punto, Ruta[] rutas, Ocupacion ocupacion) {
        return new SeccionParking(nombre, punto, rutas[0], rutas[1], ocupacion);
    }

}
