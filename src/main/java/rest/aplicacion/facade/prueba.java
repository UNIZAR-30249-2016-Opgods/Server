package rest.aplicacion.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rest.infraestructura.BBDD.ProfesorDTO;

/**
 * Created by Mario on 14/04/2016.
 */
public class prueba {


   public prueba{


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ProfesorManager pm = (ProfesorManager) context.getBean("profesorManager");


        ProfesorDTO buscado = pm.findById("id88");
        pm.cambiarDisponibilidad("id88");
        ProfesorDTO buscado2 = pm.findById("id88");
        System.out.println("Era: " + buscado.getDisponibilidad());
        System.out.println("Es: " + buscado2.getDisponibilidad());


        System.out.println("************** ENDING PROGRAM *****************");




    }

}
