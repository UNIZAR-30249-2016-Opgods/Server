package rest.aplicacion.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rest.infraestructura.BBDD.HibernateUtils;
import rest.infraestructura.BBDD.ProfesorDTO;

/**
 * Created by Mario on 14/04/2016.
 */
public class prueba {


    public prueba() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ProfesorManager profesorManager = (ProfesorManager) context.getBean("profesorManager");

        ProfesorDTO profesor = new ProfesorDTO("id", "javier", true, "info");
        profesorManager.addTeacher(profesor);

        System.out.println("************** ENDING PROGRAM *****************");




    }

}
