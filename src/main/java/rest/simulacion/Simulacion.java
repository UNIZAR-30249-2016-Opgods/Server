package rest.simulacion;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Simulacion {

    private Thread threadProfesores;
    private Thread threadSeccionesParking;

    public Simulacion() {
        threadProfesores = new Thread(new SimularProfesores());
        threadSeccionesParking = new Thread(new SimularSeccionesParking());
    }

    @PostConstruct
    public void init() {
        threadProfesores.start();
        threadSeccionesParking.start();
    }

}