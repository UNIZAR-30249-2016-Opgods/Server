package rest.dominio.objetosvalor;

public class Punto {
    private int SRC;
    private double latitud;
    private double longitud;

    public Punto(int SRC, double latitud, double longitud) {
        this.SRC = SRC;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getSRC() {
        return SRC;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

}
