package rest.aplicacion.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesores;
import rest.dominio.objetosvalor.Despacho;
import rest.dominio.objetosvalor.Localizacion;
import rest.dominio.objetosvalor.Punto;

import java.util.List;

@Service("profesorManager")
public class ProfesorManager {

    private RepositorioProfesores repositorioProfesores;

    public void setRepositorioProfesores(RepositorioProfesores repositorioProfesores) {
        this.repositorioProfesores = repositorioProfesores;
    }

    public RepositorioProfesores getRepositorioProfesores() {
        return repositorioProfesores;
    }


    @Transactional
    public String findById(String id) {
        Profesor profesor = repositorioProfesores.findById(id);
        return getJson(profesor);
    }

    @Transactional
    public String fuzzyFind(String nombre) {
        List<Profesor> profesores = repositorioProfesores.fuzzyFind(nombre);
        return getJson(profesores);
    }

    @Transactional
    public String findAll() {
        List<Profesor> profesores = repositorioProfesores.findAll();
        return getJson(profesores);
    }

    @Transactional
    public String findOne(String id) {
        Profesor profesor = repositorioProfesores.findById(id);
        return getJson(profesor);
    }

    private String getJson(Profesor profesor) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(profesor);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
    private String getJson(List<Profesor> profesor) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(profesor);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }

    @Transactional
    public void cambiarDisponibilidad(String id) {
        repositorioProfesores.modificarDisponibilidad(id);
    }

    public static void main(String[] args) {
        Profesor p = new Profesor("idprofe", "nombre",true,"informacion",new Despacho(new Localizacion(new Punto(2,2,2),1,1), "codigo"));
    }
}
