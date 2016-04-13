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
     * Pre: n debe ser menor o igual que el número de plazas libres y mayor que 0
     * Post: ocupa el número de plazas dado como parámetro en la seccion del parking.
     * @param n número de plazas a ocupar
     * @throws Exception en caso de introducir un parámetro inválido.
     */
    public void ocuparPlazas(int n) throws Exception {
        if(n < 0 || n > (ocupacion.getnPlazas() - ocupacion.getOcupadas()))
            throw new Exception("El número de plazas libres es menor que el que se va a ocupar.");
        for(int i = 0; i < n; i++)
            ocupacion.ocuparPlaza();
    }

    /**
     * Pre: n debe ser menor o igual que el número de plazas ocupadas y mayor que 0
     * Post: libera el número de plazas dado como parámetro en la seccion del parking.
     * @param n número de plazas a liberar
     * @throws Exception en caso de introducir un parámetro inválido.
     */
    public void liberarPlazas(int n) throws Exception {
        if(n < 0 || n > ocupacion.getOcupadas())
            throw new Exception("El número de plazas libres es menor que el que se va a ocupar.");
        for(int i = 0; i < n; i++)
            ocupacion.liberarPlaza();
    }

    @Override
    public void update(Observable o, Object arg) {
        String actualizar = (String) arg;
        if(actualizar.contains("ENTRAR")) {
            int plazasEntrar = Integer.parseInt(actualizar.substring(actualizar.indexOf(":") + 1, actualizar.length()));
            try {
                ocuparPlazas(plazasEntrar);
                System.out.println("Se han ocupado " + plazasEntrar + " plazas. " +
                        "Hay " + ocupacion.getOcupadas() + " plazas ocupadas." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            int plazasSalir = Integer.parseInt(actualizar.substring(actualizar.indexOf(":") + 1, actualizar.length()));
            try {
                liberarPlazas(plazasSalir);
                System.out.println("Se han liberado " + plazasSalir + " plazas. " +
                        "Hay " + ocupacion.getOcupadas() + " plazas ocupadas." );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
