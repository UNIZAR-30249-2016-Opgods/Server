package rest.infraestructura;

import java.util.Observable;

/**
 * Created by Mario on 13/4/16.
 */
public class Sensor extends Observable {
    private int plazasOcupar;
    private int plazasLiberar;

    public Sensor(int plazasOcupar, int plazasLiberar) {
        this.plazasOcupar = plazasOcupar;
        this.plazasLiberar = plazasLiberar;
    }

    public void entrar(int plazasOcupar) {
        this.plazasOcupar = plazasOcupar;

        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("ENTRAR:" + plazasOcupar);
    }

    public void salir(int plazasLiberar) {
        this.plazasLiberar = plazasLiberar;

        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("SALIR:" + plazasLiberar);
    }
}
