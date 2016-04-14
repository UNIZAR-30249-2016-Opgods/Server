package rest.infraestructura.BBDD;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Mario on 14/04/2016.
 */
@Entity
@Table(name="PROFESOR")
public class ProfesorDTO {

    @Id
    @Column(name="id", unique = true, nullable = false)
    private String id;

    @Column(name="nombre", unique = false, nullable = false)
    private String nombre;

    @Column(name="disponibilidad", unique = false, nullable = false, columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean disponibilidad;

    @Column(name="info", unique = false, nullable = false)
    private String info;

    public ProfesorDTO(String id, String nombre, boolean disponibilidad, String info) {
        this.id = id;
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public String getInfo() {
        return info;
    }

}
