package rest.profesores;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.common.JsonArrayDTO;

@RestController
public class ProfesorController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public JsonArrayDTO index() {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(0));
    }

    @RequestMapping(value = "/profesores/{planta}", method = RequestMethod.GET)
    public ResponseEntity findByFloor(@PathVariable("planta") int planta) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new ResponseEntity<JsonArrayDTO>(new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(planta)),
                                    HttpStatus.OK);
    }
    @RequestMapping(value = "/profesores/{nombre}", method = RequestMethod.GET)
    public ResponseEntity findByName(@PathVariable("nombre") String nombre) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();
        return new ResponseEntity<JsonArrayDTO>(new JsonArrayDTO(false, "Información de Profesores por nombre", repProf.fuzzyFind(nombre)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/profesores/{id}/cambiarDisponibilidad", method = RequestMethod.PUT)
    public void switchAvailability(@PathVariable("id") String id) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();
        repProf.modificarDisponibilidad(id);
    }

}
