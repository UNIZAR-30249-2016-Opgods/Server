package rest.aplicacion;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.dominio.entidades.JsonArrayDTO;
import rest.dominio.entidades.Profesor;
import rest.dominio.entidades.SeccionParking;
import rest.dominio.modelo.ConexionBBDD;
import rest.dominio.modelo.RepositorioProfesoresImpl;
import rest.dominio.objetosvalor.Despacho;
import rest.dominio.objetosvalor.Localizacion;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.infraestructura.ISensor;
import rest.infraestructura.Sensor;

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
    public JsonArrayDTO greeting(@PathVariable("planta") int planta) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(planta));
    }

}
