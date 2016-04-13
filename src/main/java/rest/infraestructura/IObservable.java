package rest.infraestructura;

import java.util.Observer;

/**
 * Created by Mario on 13/4/16.
 */
public interface IObservable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
}
