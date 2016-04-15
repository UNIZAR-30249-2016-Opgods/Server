package rest.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public abstract class Entidad {

    @Id
    @Column(name="id", unique = true, nullable = false)
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
