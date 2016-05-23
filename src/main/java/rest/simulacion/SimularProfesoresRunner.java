package rest.simulacion;

import org.springframework.stereotype.Component;
import rest.common.Sensor;
import rest.profesores.Profesor;
import rest.profesores.RepositorioProfesoresImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class SimularProfesoresRunner {

    private Thread thread;

    public SimularProfesoresRunner() {
        thread = new Thread(new SimularProfesores());
    }

    @PostConstruct
    public void init() {
        thread.start();
    }

    @PreDestroy
    public void destroy() {
        thread.stop();
    }


}