package rest.aplicacion.simulacion;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Simulacion {

    private Thread threadProfesores;
    private Thread threadSeccionesParking;
    private Thread threadCafeterias;

    public Simulacion() {
        threadProfesores = new Thread(new SimularProfesores());
        threadSeccionesParking = new Thread(new SimularSeccionesParking());
        threadCafeterias = new Thread(new SimularCafeterias());
    }

    @PostConstruct
    public void init() {
        threadProfesores.start();
        threadSeccionesParking.start();
        threadCafeterias.start();
    }

}