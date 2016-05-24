package rest.common;

public class Localizacion {

    private Punto punto;
    private int utcPlanta;
    private int utcEdificio;

    public Localizacion(Punto punto, int utcPlanta, int utcEdificio) {
        this.punto = punto;
        this.utcPlanta = utcPlanta;
        this.utcEdificio = utcEdificio;
    }

    public Punto getPunto() {
        return punto;
    }

    public int getUtcPlanta() {
        return utcPlanta;
    }

    public int getUtcEdificio() {
        return utcEdificio;
    }

}
