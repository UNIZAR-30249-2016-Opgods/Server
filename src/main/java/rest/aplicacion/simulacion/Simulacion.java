package rest.aplicacion.simulacion;

import rest.dominio.simulacion.SimularParking;
import rest.dominio.simulacion.SimularProfesor;

public class Simulacion extends Thread {

    public Simulacion() {
        SimularParking sParking = new SimularParking();
        SimularProfesor sProfesor = new SimularProfesor();

        new Thread(sParking).start();
        new Thread(sProfesor).start();
    }
}
