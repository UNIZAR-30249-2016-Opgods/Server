package rest.TestSeccionesParking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.infraestructura.ParkingEndPoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ParkingEndPoint.class)
public class ParkingEndPointTest {

    private MockMvc mockMvc;

    @Autowired
    private ParkingEndPoint parkingController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(parkingController).build();
    }

    @Test
    public void obtenerSecciones() throws Exception {
        this.mockMvc.perform(get("/parking/secciones"))
                .andExpect(status().isOk());
    }

    @Test
    public void obtenerPuntosDeAcceso() throws Exception {
        this.mockMvc.perform(get("/parking/puntosDeAcceso"))
                .andExpect(status().isOk());
    }
}
