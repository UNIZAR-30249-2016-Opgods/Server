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

    @RequestMapping(value = "/profesores/{planta}", method = RequestMethod.GET)
    public ResponseEntity findByFloor(@PathVariable("planta") int planta) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();

        return new ResponseEntity<>(new JsonArrayDTO(false, "Información de Profesores por planta", repProf.findFloor(planta)),
                                    HttpStatus.OK);
    }

    @RequestMapping(value = "/profesores/fuzzyFind/{nombre}", method = RequestMethod.GET)
    public ResponseEntity findByName(@PathVariable("nombre") String nombre) {
        RepositorioProfesoresImpl repProf = new RepositorioProfesoresImpl();
        return new ResponseEntity<>(new JsonArrayDTO(false, "Información de Profesores por nombre", repProf.fuzzyFind(nombre)),
                HttpStatus.OK);
    }

}
