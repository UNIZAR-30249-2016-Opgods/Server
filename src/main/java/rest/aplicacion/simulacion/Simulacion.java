package rest.aplicacion.simulacion;

import rest.dominio.simulacion.SimularParking;


/**
 * Created by Mario on 13/4/16.
 */
public class Simulacion extends Thread {

    public static void main(String[] args) {
        SimularParking sp = new SimularParking();

        new Thread(sp).start();
    }
}
