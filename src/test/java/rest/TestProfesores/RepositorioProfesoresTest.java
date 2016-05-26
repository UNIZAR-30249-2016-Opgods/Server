package rest.TestProfesores;

import org.junit.Test;
import rest.dominio.profesores.Profesor;
import rest.dominio.profesores.RepositorioProfesoresImpl;
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
    public void actualizarProfesor () throws Exception {
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        List<Profesor> profesorList = repo.fuzzyFind("Rubén Béjar Hernández");
        boolean exito = repo.modificarDisponibilidad(profesorList.get(0));

        assertTrue(exito);
    }

    @Test
    public void buscarTodosLosProfesores() {
        RepositorioProfesoresImpl repo = new RepositorioProfesoresImpl();
        assertNotEquals(0, repo.findAll().size());
    }

}