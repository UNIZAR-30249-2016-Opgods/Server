package rest.TestCommon;

import org.junit.Test;
import rest.infraestructura.ConexionBBDD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BBDDTest {


    @Test
    public void igualConexion () {
        assertEquals(ConexionBBDD.conectar(), ConexionBBDD.conectar());
    }

}