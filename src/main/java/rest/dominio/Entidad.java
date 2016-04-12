package rest.dominio;

import java.util.UUID;

/**
 * Created by phyrion on 12/04/16.
 */
public abstract class Entidad {
    private UUID id;

    public Entidad () {
        id = UUID.randomUUID();
    }

    public UUID getId () {
        return id;
    }
}
