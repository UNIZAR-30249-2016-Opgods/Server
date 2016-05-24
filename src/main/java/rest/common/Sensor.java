package rest.common;

import java.util.Observable;

public class Sensor extends Observable {

    public void entrar() {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("ENTRAR");
    }

    public void salir() {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers("SALIR");
    }

}
