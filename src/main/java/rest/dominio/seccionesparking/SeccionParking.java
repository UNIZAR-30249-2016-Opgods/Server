package rest.dominio.seccionesparking;

import rest.dominio.common.Constantes;
import rest.dominio.common.Ocupacion;
import rest.dominio.common.Punto;
import rest.dominio.common.Entidad;

import java.util.Observable;
import java.util.Observer;

public class SeccionParking extends Entidad implements Observer, Comparable {

    private String nombre;
    private Punto punto;
    private Ocupacion ocupacion;

    // Inserciones en la BBDD y JSON
    public SeccionParking(String nombre, Punto punto, Ocupacion ocupacion) {
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public SeccionParking(String id, String nombre, Punto punto, Ocupacion ocupacion) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Punto getPunto() {
        return punto;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
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
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        RepositorioSeccionParkingImpl repo = new RepositorioSeccionParkingImpl();
        try {
            if(actualizar.contains(Constantes.ENTRAR)) {
                ocuparPlaza();
                repo.actualizarParking(this);
                //System.out.println("Se han ocupado una plaza del parking [" + nombre + "].");

            } else {
                liberarPlaza();
                repo.actualizarParking(this);
                //System.out.println("Se han liberado una plaza del parking [" + nombre + "].");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int compareTo(Object o) {
        int comparacion = Integer.parseInt(((SeccionParking) o).getId());
        return Integer.parseInt(this.getId())-comparacion;
    }

}
