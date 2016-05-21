package rest.aplicacion;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.dominio.entidades.JsonArrayDTO;
import rest.dominio.entidades.Profesor;
import rest.dominio.entidades.SeccionParking;
import rest.dominio.modelo.ConexionBBDD;
import rest.dominio.modelo.RepositorioProfesoresImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProfesorController {

    private static final String template = "Hello OP chetao Bien formado, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public JsonArrayDTO index() {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(0));
    }

    @RequestMapping(value = "/profesores/{planta}", method = RequestMethod.GET)
    public ResponseEntity greeting(@PathVariable("planta") int planta) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new ResponseEntity<JsonArrayDTO>(new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(planta)),
                                    HttpStatus.OK);
    }


    @RequestMapping(value = "/profesores/{id}/cambiarDisponibilidad", method = RequestMethod.GET)
    public void switchAvailability(@PathVariable("id") String id) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();
        repProf.modificarDisponibilidad(id);
    }

}
