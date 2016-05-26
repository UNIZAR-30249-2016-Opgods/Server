package rest.TestCommon;

import org.junit.BeforeClass;
import org.junit.Test;
import rest.dominio.common.Ocupacion;

import static org.junit.Assert.assertEquals;

public class OcupacionTest {

    private static Ocupacion ocupacion;
    private static Ocupacion ocupacionVacia;
    private static Ocupacion ocupacionLlena;

    @BeforeClass
    public static void beforeClass(){
        ocupacion = new Ocupacion(60, 30);
        ocupacionLlena = new Ocupacion(60, 60);
        ocupacionVacia = new Ocupacion(60,0);
    }

    @Test
    public void ocuparEnOcupacionNormal () {
        int ocupadasAntes = ocupacion.getOcupadas();
        ocupacion.ocuparPlaza();
        assertEquals(ocupacion.getOcupadas(),ocupadasAntes+1);
    }

    @Test
    public void liberarEnOcupacionNormal () {
        int ocupadasAntes = ocupacion.getOcupadas();
        ocupacion.liberarPlaza();
        assertEquals(ocupacion.getOcupadas(),ocupadasAntes-1);
    }

    @Test
    public void liberarEnOcupacionVacia () {
        int ocupadasAntes = ocupacionVacia.getOcupadas();
        ocupacionVacia.liberarPlaza();
        assertEquals(ocupacionVacia.getOcupadas(),ocupadasAntes);
    }

    @Test
    public void ocuparEnOcupacionLlena () {
        int ocupadasAntes = ocupacionLlena.getOcupadas();
        ocupacionLlena.ocuparPlaza();
        assertEquals(ocupacionLlena.getOcupadas(),ocupadasAntes);
    }

}