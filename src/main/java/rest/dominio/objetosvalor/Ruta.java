package rest.dominio.objetosvalor;

import javafx.scene.shape.Polyline;

/**
 * Created by phyrion on 12/04/16.
 */
public class Ruta {
    private Polyline polyline;
    private AccesoParking acceso;

    public Ruta(Polyline polyline, AccesoParking acceso) {
        this.polyline = polyline;
        this.acceso = acceso;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public AccesoParking getAcceso() {
        return acceso;
    }
}
