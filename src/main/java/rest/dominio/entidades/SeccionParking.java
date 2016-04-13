package rest.dominio.entidades;

import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;
import rest.dominio.objetosvalor.Ruta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by phyrion on 12/04/16.
 */
public class SeccionParking extends Entidad implements Observer {

    private String nombre;
    private Punto punto;
    private Ruta[] rutas = new Ruta[2];
    private Ocupacion ocupacion;

    public SeccionParking(String nombre, Punto punto, Ruta ruta1, Ruta ruta2, Ocupacion ocupacion) {
        this.nombre = nombre;
        this.punto = punto;
        this.rutas[0] = ruta1;
        this.rutas[1] = ruta2;
        this.ocupacion = ocupacion;
    }

    public SeccionParking(String id, String nombre, Punto punto, Ruta ruta1, Ruta ruta2, Ocupacion ocupacion) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.rutas[0] = ruta1;
        this.rutas[1] = ruta2;
        this.ocupacion = ocupacion;
    }

    /**
     * Pre: Debe haber un número de plazas libres mayor que 0
     * Post: ocupa una plaza en la seccion del parking.
     * @throws Exception en caso de no haber plazas libres.
     */
    public void ocuparPlaza() throws Exception {
        if(ocupacion.getLibres() == 0)
            throw new Exception("No quedan plazas libres.");

        ocupacion.ocuparPlaza();
    }

    /**
     * Pre: El parking no debe estar vacío
     * Post: libera una plaza la seccion del parking.
     * @throws Exception en caso de que el parking esté vacío.
     */
    public void liberarPlaza() throws Exception {
        if(ocupacion.getOcupadas() == 0)
            throw new Exception("El parking ya estaba vacío.");

        ocupacion.liberarPlaza();
    }

    @Override
    //TODO: Cambiar try catch por throws. Esto es solo para probar
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        if(actualizar.contains("ENTRAR")) {
            try {
                ocuparPlaza();
                System.out.println("Se han ocupado una plaza del parking. " +
                        "Hay " + ocupacion.getOcupadas() + " plazas ocupadas." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                liberarPlaza();
                System.out.println("Se han liberado una plaza del parking. " +
                        "Hay " + ocupacion.getLibres() + " plazas libres." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
