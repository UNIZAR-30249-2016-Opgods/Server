package rest.TestProfesores;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.aplicacion.ProfesorEndPoint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ProfesorEndPoint.class)
public class ProfesorEndPointTest {

    private MockMvc mockMvc;

    @Autowired
    private ProfesorEndPoint profesorController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(profesorController).build();
    }

    @Test
    public void obtenerProfesoresPlanta0() throws Exception {
        this.mockMvc.perform(get("/profesores/{planta}", 0))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerProfesoresPlanta1() throws Exception {
        this.mockMvc.perform(get("/profesores/{planta}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerProfesoresPlanta2() throws Exception {
        this.mockMvc.perform(get("/profesores/{planta}", 2))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerProfesoresPlanta3() throws Exception {
        this.mockMvc.perform(get("/profesores/{planta}", 3))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerProfesoresPlanta4() throws Exception {
        this.mockMvc.perform(get("/profesores/{planta}", 4))
                .andExpect(status().isOk());
    }

    @Test
    public void busquedaPorNombre() throws Exception {
        this.mockMvc.perform(get("/profesores/fuzzyFind/{nombre}", "Javier"))
                .andExpect(status().isOk());
    }

    @Test(expected=IllegalArgumentException.class)
    public void busquedaPorNombreNull() throws Exception {
        this.mockMvc.perform(get("/profesores/fuzzyFind/{nombre}", null));
    }

    @Test
    public void busquedaPorNombreVacio() throws Exception {
        this.mockMvc.perform(get("/profesores/fuzzyFind/{nombre}", ""))
                .andExpect(status().isBadRequest());
    }

}
