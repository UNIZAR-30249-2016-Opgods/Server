package rest.infraestructura;

import java.util.Observable;

/**
 * Created by Mario on 13/4/16.
 */
public class Sensor extends Observable {

    public void entrar(int plazasOcupar) {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("ENTRAR:" + plazasOcupar);
    }

    public void salir(int plazasLiberar) {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("SALIR:" + plazasLiberar);
    }
}
