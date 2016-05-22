package rest.seccionesparking;

public class Ruta {
    //TODO Ver que pasa con la clase Polyline hacer las rutas con googlemaps
    private int polyline; // Problemas en heroku
    private AccesoParking acceso;

    public Ruta(int polyline, AccesoParking acceso) {
        this.polyline = polyline;
        this.acceso = acceso;
    }

    public int getPolyline() {
        return polyline;
    }

    public AccesoParking getAcceso() {
        return acceso;
    }
}
