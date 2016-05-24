package rest.cafeterias;

import rest.common.Entidad;
import rest.common.Ocupacion;
import rest.common.Punto;

import java.util.Observable;
import java.util.Observer;

public class Cafeteria extends Entidad implements Observer, Comparable{

    private String nombre;
    private Punto punto;
    private Ocupacion ocupacion;

    public Cafeteria(String nombre, Punto punto, Ocupacion ocupacion) {
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public Cafeteria(String id, String nombre, Punto punto, Ocupacion ocupacion) {
        super(id);
        this.nombre = nombre;
        this.punto = punto;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
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
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        RepositorioCafeteriasImpl repo = new RepositorioCafeteriasImpl();
        if(actualizar.contains("ENTRAR")) {
            try {
                repo.ocuparPlaza(getId());

                //System.out.println("Se han ocupado una plaza de la cafeteria.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                repo.liberarPlaza(getId());

                //System.out.println("Se han liberado una plaza de la cafeteria.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        int comparacion = Integer.parseInt(((Cafeteria) o).getId());
        return Integer.parseInt(this.getId())-comparacion;
    }

}
