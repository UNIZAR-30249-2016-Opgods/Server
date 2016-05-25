package rest.TestCommon;

import org.junit.BeforeClass;
import org.junit.Test;
import rest.common.ConexionBBDD;
import rest.common.Ocupacion;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BBDDTest {


    @Test
    public void igualConexion () {
        assertEquals(ConexionBBDD.conectar(), ConexionBBDD.conectar());
    }

}