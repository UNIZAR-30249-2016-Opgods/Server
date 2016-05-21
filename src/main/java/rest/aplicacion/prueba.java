package rest.aplicacion;

import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesoresImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 21/05/2016.
 */
public class prueba {

    public static void main(String[] args) {
        //ProfesorController pc = new ProfesorController();
        //pc.switchAvailability("1");
        RepositorioProfesoresImpl repositorioProfesores = new RepositorioProfesoresImpl();
        repositorioProfesores.modificarDisponibilidad("2");
    }

}
