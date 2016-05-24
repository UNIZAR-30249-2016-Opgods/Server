package rest.TestSeccionesParking;

import org.junit.Test;
import rest.common.Punto;
import rest.seccionesparking.RepositorioSeccionParkingImpl;
import rest.seccionesparking.SeccionParking;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void ocuparPlaza () throws Exception {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();

        List<SeccionParking> seccionParkingList = repo.obtenerSecciones();
        int numOcupadasAntes = seccionParkingList.get(0).getOcupacion().getOcupadas();
        String id = seccionParkingList.get(0).getId();

        repo.ocuparPlaza(id);
        SeccionParking seccionParkingActualizada = repo.findById(id);

        assertEquals(seccionParkingList.get(0).getId(), seccionParkingActualizada.getId());
        assertEquals(seccionParkingActualizada.getOcupacion().getOcupadas(), numOcupadasAntes+1);
    }

    @Test
    public void liberarPlaza () throws Exception {
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();

        List<SeccionParking> seccionParkingList = repo.obtenerSecciones();
        int numOcupadasAntes = seccionParkingList.get(0).getOcupacion().getOcupadas();
        String id = seccionParkingList.get(0).getId();

        repo.liberarPlaza(id);
        SeccionParking seccionParkingActualizada = repo.findById(id);

        assertEquals(seccionParkingList.get(0).getId(), seccionParkingActualizada.getId());
        assertEquals(seccionParkingActualizada.getOcupacion().getOcupadas(), numOcupadasAntes-1);
    }

}