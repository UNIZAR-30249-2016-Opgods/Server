package rest.aplicacion.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dominio.entidades.Profesor;
import rest.dominio.entidades.SeccionParking;
import rest.dominio.modelo.RepositorioProfesores;
import rest.dominio.modelo.RepositorioSeccionParking;

import java.util.List;

@Service("seccionParkingManager")
public class SeccionParkingManager {

    private RepositorioSeccionParking repositorioSeccionParking;

    public void setRepositorioSeccionParking(RepositorioSeccionParking repositorioSeccionParking) {
        this.repositorioSeccionParking = repositorioSeccionParking;
    }

    public RepositorioSeccionParking getRepositorioSeccionParking() {
        return repositorioSeccionParking;
    }

    @Transactional
    public String obtenerSecciones() {
        List<SeccionParking> seccionParking = repositorioSeccionParking.obtenerSecciones();
        return getJson(seccionParking);
    }

    @Transactional
    public void ocuparPlaza(String id) throws Exception {
        repositorioSeccionParking.ocuparPlaza(id);
    }

    @Transactional
    public void liberarPlaza(String id) throws Exception {
        repositorioSeccionParking.liberarPlaza(id);
    }

    @Transactional
    public String findById(String id) {
        SeccionParking seccionParking = repositorioSeccionParking.findById(id);
        return getJson(seccionParking);
    }

    private String getJson(SeccionParking seccionParking) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(seccionParking);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
    private String getJson(List<SeccionParking> seccionParking) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(seccionParking);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}
