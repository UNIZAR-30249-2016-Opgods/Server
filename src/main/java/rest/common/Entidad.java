package rest.common;

import java.util.UUID;

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
