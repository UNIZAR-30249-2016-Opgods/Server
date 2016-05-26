package rest.TestProfesores;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rest.dominio.common.Localizacion;
import rest.dominio.common.Punto;
import rest.infraestructura.Sensor;
import rest.dominio.profesores.Despacho;
import rest.dominio.profesores.Profesor;

public class ProfesoresTest {

    private static Profesor profesorDisponible;
    private static Profesor profesorOcupado;
    private static Sensor sensor;

    @BeforeClass
    public static void beforeClass() {
        profesorDisponible = new Profesor("Nombre", true, "informacion",
                new Despacho(new Localizacion(new Punto(1.0,2.0), 1,2), "codigo"));
        profesorOcupado = new Profesor("Nombre", false, "informacion",
                new Despacho(new Localizacion(new Punto(1.0,2.0), 1,2), "codigo"));
        sensor = new Sensor();
    }

    @Test
    public void sensorAvisaParaEstarDisponible () {
        sensor.addObserver(profesorOcupado);
        sensor.entrar();
        assertTrue(profesorOcupado.isDisponibilidad());
    }

    @Test
    public void sensorAvisaParaEstarOcupado () {
        sensor.addObserver(profesorDisponible);
        sensor.salir();
        assertFalse(profesorDisponible.isDisponibilidad());
    }

    @Test
    public void compararProfesores() {
        assertNotEquals(0, profesorDisponible.compareTo(profesorOcupado));
    }

    @Test
    public void introducirProfesorSinDespacho() {
        String id = "unID";
        Profesor profesorTemp = new Profesor(id,"Nombre", false, "informacion");
        assertEquals(id, profesorTemp.getId());
    }
}