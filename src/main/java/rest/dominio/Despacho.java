package rest.dominio;

/**
 * Created by phyrion on 12/04/16.
 */
public class Despacho {
    private Localizacion localizacion;
    private String codigo;

    public Despacho(Localizacion localizacion, String codigo) {
        this.codigo = codigo;
    }
}
