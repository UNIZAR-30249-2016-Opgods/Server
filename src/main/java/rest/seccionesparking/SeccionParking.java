package rest.seccionesparking;

import rest.common.Punto;
import rest.common.Entidad;

import java.util.Observable;
import java.util.Observer;

public class SeccionParking extends Entidad implements Observer {

    private String nombre;
    private Punto punto;
    private Ocupacion ocupacion;
    private AccesoParking[] accesosParking = new AccesoParking[2];

    public SeccionParking(String nombre, Punto punto, Ocupacion ocupacion, AccesoParking acceso1, AccesoParking acceso2) {
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
        this.accesosParking[0] = acceso1;
        this.accesosParking[1] = acceso2;
    }

    public SeccionParking(String id, String nombre, Punto punto, Ocupacion ocupacion, AccesoParking acceso1, AccesoParking acceso2) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
        this.accesosParking[0] = acceso1;
        this.accesosParking[1] = acceso2;
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

    public Ocupacion obtenerOcupacion() {
        return ocupacion;
    }

    @Override
    //TODO: Cambiar try catch por throws. Esto es solo para probar
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        if(actualizar.contains("ENTRAR")) {
            try {
                ocuparPlaza();
                System.out.println("Se han ocupado una plaza del parking [" + nombre + "]. " +
                        "Hay " + ocupacion.getOcupadas() + " plazas ocupadas." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                liberarPlaza();
                System.out.println("Se han liberado una plaza del parking [" + nombre + "]. " +
                        "Hay " + ocupacion.getLibres() + " plazas libres." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
