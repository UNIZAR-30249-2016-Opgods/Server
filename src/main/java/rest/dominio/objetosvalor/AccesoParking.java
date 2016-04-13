package rest.dominio.objetosvalor;

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
