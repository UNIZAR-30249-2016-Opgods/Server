package rest.aplicacion;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.dominio.entidades.SeccionParking;
import rest.dominio.infraestructura.Sensor;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello OP chetao Bien formado, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greetings/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable("name") String name) {
        /*return new Greeting(counter.incrementAndGet(),
                String.format(template, name));*/
        SeccionParking sp = new SeccionParking("Seccion tal",
                                                new Punto(1,1),
                                                null, null,
                                                new Ocupacion(12,2));
        Sensor sensor = new Sensor();
        sensor.addObserver(sp);
        sensor.entrar();

        /*User user;
        user = new User("op@op.com", name);
        userDao.save(user);*/
        return "<h1>Inicio de app</h1>";
    }

}
