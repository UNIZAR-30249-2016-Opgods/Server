package rest.aplicacion;

import rest.dominio.modelo.RepositorioProfesoresImpl;

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
