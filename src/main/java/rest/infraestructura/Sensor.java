package rest.infraestructura;

import rest.dominio.common.Constantes;

import java.util.Observable;

public class Sensor extends Observable {

    public void entrar() {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers(Constantes.ENTRAR);
    }

    public void salir() {
        // Marca el objeto observable como un objeto que ha cambiado
        setChanged();
        // Notificamos a los observadores y le enviamos el nuevo valor
        notifyObservers(Constantes.SALIR);
    }

}
