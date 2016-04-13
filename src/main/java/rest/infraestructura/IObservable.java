package rest.infraestructura;

import java.util.Observer;

public interface IObservable {
    void addObserver(Observer o);
    void deleteObserver(Observer o);
}
