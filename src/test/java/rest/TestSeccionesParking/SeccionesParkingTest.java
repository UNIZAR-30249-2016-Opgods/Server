package rest.TestSeccionesParking;

import org.junit.BeforeClass;
import org.junit.Test;
import rest.common.Ocupacion;
import rest.common.Punto;
import rest.common.Sensor;
import rest.seccionesparking.SeccionParking;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SeccionesParkingTest {

    private static SeccionParking seccionParking;
    private static SeccionParking seccionParkingVacia;
    private static SeccionParking seccionParkingLlena;
    private static Sensor sensor;

    @BeforeClass
    public static void beforeClass() {
        seccionParking = new SeccionParking("Nombre", new Punto(1.0,2.0), new Ocupacion(60, 30));
        seccionParkingVacia = new SeccionParking("Nombre", new Punto(1.0,2.0), new Ocupacion(60, 0));
        seccionParkingLlena = new SeccionParking("Nombre", new Punto(1.0,2.0), new Ocupacion(60, 60));
        sensor = new Sensor();
    }


    @Test
    public void sensorOcupaSitioDeParking () {
        sensor.addObserver(seccionParking);
        int ocupadosAntes = seccionParking.getOcupacion().getOcupadas();
        sensor.entrar();
        assertEquals(seccionParking.getOcupacion().getOcupadas(), ocupadosAntes+1);
    }

    @Test
    public void sensorLiberaSitioDeParking () {
        sensor.addObserver(seccionParking);
        int ocupadosAntes = seccionParking.getOcupacion().getOcupadas();
        sensor.salir();
        assertEquals(seccionParking.getOcupacion().getOcupadas(), ocupadosAntes-1);
    }

    @Test
    public void sensorOcupaSitioDeParkingLleno () {
        sensor.addObserver(seccionParkingLlena);
        int ocupadosAntes = seccionParkingLlena.getOcupacion().getOcupadas();
        sensor.entrar();
        assertEquals(seccionParkingLlena.getOcupacion().getOcupadas(), ocupadosAntes);
    }

    @Test
    public void sensorLiberaSitioDeParkingVacio () {
        sensor.addObserver(seccionParkingVacia);
        int ocupadosAntes = seccionParkingVacia.getOcupacion().getOcupadas();
        sensor.salir();
        assertEquals(seccionParkingVacia.getOcupacion().getOcupadas(), ocupadosAntes);
    }

    @Test
    public void liberarSitio () throws Exception {
        int ocupadosAntes = seccionParking.getOcupacion().getOcupadas();
        seccionParking.liberarPlaza();
        assertEquals(seccionParking.getOcupacion().getOcupadas(), ocupadosAntes-1);
    }

    @Test
    public void ocuparSitio () throws Exception {
        int ocupadosAntes = seccionParking.getOcupacion().getOcupadas();
        seccionParking.ocuparPlaza();
        assertEquals(seccionParking.getOcupacion().getOcupadas(), ocupadosAntes+1);
    }

    @Test(expected = Exception.class)
    public void ocuparSitioEnParkingLleno () throws Exception {
        seccionParkingLlena.ocuparPlaza();
    }

    @Test(expected = Exception.class)
    public void liberarSitioEnParkingVacio () throws Exception {
        seccionParkingVacia.liberarPlaza();
    }

}