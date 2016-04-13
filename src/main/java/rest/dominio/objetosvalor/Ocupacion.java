package rest.dominio.objetosvalor;

/**
 *
 */
public class Ocupacion {
    private int nPlazas;
    private int ocupadas;

    public Ocupacion(int nPlazas, int ocupadas) {
        this.nPlazas = nPlazas;
        this.ocupadas = ocupadas;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public int getLibres() { return nPlazas - ocupadas; }

    public void ocuparPlaza() {
        if (ocupadas < nPlazas) {
            ocupadas++;
        }
    }

    public void liberarPlaza() {
        if(ocupadas > 0) {
            ocupadas--;
        }
    }
}
