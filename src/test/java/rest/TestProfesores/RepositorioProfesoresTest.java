package rest.TestProfesores;

import org.junit.Test;
import rest.profesores.Profesor;
import rest.profesores.RepositorioProfesoresImpl;
import java.util.List;
import static org.junit.Assert.*;

public class RepositorioProfesoresTest {

    @Test
    public void busquedaPorNombre () {
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        List<Profesor> profesorList = repo.fuzzyFind("Rubén Béjar Hernández");
        assertEquals(1, profesorList.size());
        assertEquals(profesorList.get(0).getNombre(), "Rubén Béjar Hernández");
    }

    @Test
    public void modificarDisponibilidad () {
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        List<Profesor> profesorList = repo.fuzzyFind("Rubén Béjar Hernández");
        boolean disponibilidadAntes = profesorList.get(0).isDisponibilidad();
        repo.modificarDisponibilidad(profesorList.get(0).getId());
        profesorList = repo.fuzzyFind("Rubén Béjar Hernández");
        if (disponibilidadAntes) {
            assertFalse(profesorList.get(0).isDisponibilidad());
        } else {
            assertTrue(profesorList.get(0).isDisponibilidad());
        }
    }

    @Test
    public void buscarTodosLosProfesores() {
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        assertNotEquals(0, repo.findAll().size());
    }

}