package rest.dominio.objetosvalor;

/**
 * Created by phyrion on 12/04/16.
 */
public class Despacho {
    private Localizacion localizacion;
    private String codigo;

    public Despacho(Localizacion localizacion, String codigo) {
        this.localizacion = localizacion;
        this.codigo = codigo;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public String getCodigo() {
        return codigo;
    }
}
