package rest.aplicacion.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rest.dominio.entidades.Profesor;
import rest.dominio.modelo.RepositorioProfesores;
import rest.dominio.modelo.RepositorioProfesoresImpl;
import rest.infraestructura.BBDD.HibernateUtils;
import rest.infraestructura.BBDD.ProfesorDTO;

import java.util.ArrayList;

/**
 * Created by Mario on 14/04/2016.
 */
public class prueba {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ProfesorManager profesorManager = (ProfesorManager) context.getBean("profesorManager");
        HibernateUtils hu = new HibernateUtils();

        ProfesorDTO profesor = new ProfesorDTO("id", "javier", true, "info");
        profesorManager.addTeacher(profesor);

        System.out.println("************** ENDING PROGRAM *****************");




    }

}
