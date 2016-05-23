package rest.TestCafeterias;

import org.junit.Test;
import rest.cafeterias.Cafeteria;
import rest.cafeterias.RepositorioCafeteriasImpl;

import java.util.List;

import static org.junit.Assert.*;

public class RepositorioCafeteriasTest {

    @Test
    public void obtenerCafeterias () {
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();
        List<Cafeteria> cafeteriaList = repo.obtenerCafeterias();
        assertTrue(cafeteriaList.size()>0);
    }


    @Test
    public void ocuparPlaza () throws Exception {
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();

        List<Cafeteria> cafeteriaList = repo.obtenerCafeterias();
        int numOcupadasAntes = cafeteriaList.get(0).getOcupacion().getOcupadas();
        String id = cafeteriaList.get(0).getId();

        repo.ocuparPlaza(id);
        Cafeteria cafeteriaActualizada = repo.findById(id);

        assertEquals(cafeteriaList.get(0).getId(), cafeteriaActualizada.getId());
        assertEquals(cafeteriaActualizada.getOcupacion().getOcupadas(), numOcupadasAntes+1);
    }

    @Test
    public void liberarPlaza () throws Exception {
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();

        List<Cafeteria> cafeteriaList = repo.obtenerCafeterias();
        int numOcupadasAntes = cafeteriaList.get(0).getOcupacion().getOcupadas();
        String id = cafeteriaList.get(0).getId();

        repo.liberarPlaza(id);
        Cafeteria cafeteriaActualizada = repo.findById(id);

        assertEquals(cafeteriaList.get(0).getId(), cafeteriaActualizada.getId());
        assertEquals(cafeteriaActualizada.getOcupacion().getOcupadas(), numOcupadasAntes-1);
    }


}