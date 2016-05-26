package rest.TestSeccionesParking;

import org.junit.Test;
import rest.common.Punto;
import rest.seccionesparking.RepositorioSeccionParkingImpl;
import rest.seccionesparking.SeccionParking;
import java.util.List;
import static org.junit.Assert.*;

public class RepositorioSeccionParkingTest {

    @Test
    public void obtenerSeccionesParking () {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        List<SeccionParking> seccionParkingList = repo.obtenerSecciones();
        assertTrue(seccionParkingList.size()>0);
    }

    @Test
    public void obtenerPuntosAcceso () {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        List<Punto> puntosAcceso = repo.obtenerPuntosAcceso();
        assertTrue(puntosAcceso.size()>0);
    }

    @Test
    public void actualizarParking () throws Exception {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        List<SeccionParking> parkingList = repo.obtenerSecciones();
        boolean exito = repo.actualizarParking(parkingList.get(0));

        assertTrue(exito);
    }

    @Test
    public void actualizarParkingNull () throws Exception {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        boolean exito = repo.actualizarParking(null);

        assertFalse(exito);
    }

}