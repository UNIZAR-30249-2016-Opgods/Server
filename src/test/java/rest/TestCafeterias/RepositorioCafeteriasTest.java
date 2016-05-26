package rest.TestCafeterias;

import org.junit.Test;
import rest.cafeterias.Cafeteria;
import rest.cafeterias.RepositorioCafeterias;
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
    public void actualizarCafeteria () throws Exception {
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();
        List<Cafeteria> parkingList = repo.obtenerCafeterias();
        boolean exito = repo.actualizarCafeteria(parkingList.get(0));

        assertTrue(exito);
    }

}