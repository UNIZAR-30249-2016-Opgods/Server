package rest.aplicacion;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.dominio.cafeterias.RepositorioCafeteriasImpl;

@RestController
public class CafeteriaEndPoint {

    @RequestMapping(value = "/cafeterias", method = RequestMethod.GET)
    public ResponseEntity listCafeterias() {
        RepositorioCafeteriasImpl rcaf = new RepositorioCafeteriasImpl();

        return new ResponseEntity<>(new JsonArrayDTO(false, "Información cafeterias", rcaf.obtenerCafeterias()),
                                    HttpStatus.OK);
    }
}
