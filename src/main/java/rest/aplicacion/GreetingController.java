package rest.aplicacion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.dominio.entidades.Profesor;
import rest.models.UserDao;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello OP chetao Bien formado, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greetings/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable("name") String name) {
        /*return new Greeting(counter.incrementAndGet(),
                String.format(template, name));*/
        Profesor profesor = new Profesor();
        /*User user;
        user = new User("op@op.com", name);
        userDao.save(user);*/
        return "<h1>Inicio de app</h1>";
    }

    @Autowired
    private UserDao userDao;
}
