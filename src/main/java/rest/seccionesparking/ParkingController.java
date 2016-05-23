package rest.seccionesparking;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.common.JsonArrayDTO;

@RestController
public class ParkingController {


    @RequestMapping(value = "/parking/secciones", method = RequestMethod.GET)
    public ResponseEntity getSeccionesParking() {
        RepositorioSeccionParkingImpl repParking = new RepositorioSeccionParkingImpl();

        return new ResponseEntity<JsonArrayDTO>(new JsonArrayDTO(false,
                "Información de secciones de parking", repParking.obtenerSecciones()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/parking/puntosDeAcceso", method = RequestMethod.GET)
    public ResponseEntity getPuntosDeAcceso() {
        RepositorioSeccionParkingImpl repParking = new RepositorioSeccionParkingImpl();

        return new ResponseEntity<JsonArrayDTO>(new JsonArrayDTO(false,
                "Información de puntos de acceso", repParking.obtenerPuntosAcceso()),
                HttpStatus.OK);
    }

}
