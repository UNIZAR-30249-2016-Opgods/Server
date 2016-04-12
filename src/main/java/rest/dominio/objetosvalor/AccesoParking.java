package rest.dominio.objetosvalor;

/**
 * Created by phyrion on 12/04/16.
 */
public class AccesoParking {
    private Punto punto;
    private int entrada;

    public AccesoParking(Punto punto, int entrada) {
        this.punto = punto;
        this.entrada = entrada;
    }

    public Punto getPunto() {
        return punto;
    }

    public int getEntrada() {
        return entrada;
    }
}
