package rest.TestCafeterias;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.cafeterias.CafeteriaController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CafeteriaController.class)
public class CafeteriasControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CafeteriaController cafeteriaController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cafeteriaController).build();
    }

    @Test
    public void obtenerCafeterias() throws Exception {
        this.mockMvc.perform(get("/cafeterias"))
                .andExpect(status().isOk());
    }

}
