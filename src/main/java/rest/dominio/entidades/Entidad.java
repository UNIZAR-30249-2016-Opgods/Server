package rest.dominio.entidades;

import java.util.UUID;

/**
 * Created by phyrion on 12/04/16.
 */
public abstract class Entidad {
    private String id;

    public Entidad () {
        id = UUID.randomUUID().toString();
    }

    public Entidad (String id) {
        this.id = id;
    }

    public String getId () {
        return id;
    }
}
