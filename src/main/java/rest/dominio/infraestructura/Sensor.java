package rest.dominio.infraestructura;

import java.util.Observable;

/**
 * Created by phyrion on 12/04/16.
 */
public class Sensor extends Observable{

    public void entrar() {
        setChanged();
        notifyObservers("ENTRA");
    }

    public void salir() {
        setChanged();
        notifyObservers("SALIR");
    }
}
