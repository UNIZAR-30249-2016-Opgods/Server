package rest.infraestructura;

import java.util.Observable;

public class Sensor extends Observable implements ISensor {

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
