package rest.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profesor")
public class Profesor {
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // The teacher's name
    @NotNull
    private String name;

    // The teacher's disponibility
    @NotNull
    private boolean disponibility;

    @NotNull
    private String info;

    public Profesor() { }

    public Profesor(long id) {
        this.id = id;
    }

    public Profesor(String name, boolean disponibility, String info) {
        this.name = name;
        this.disponibility = disponibility;
        this.info = info;
    }

    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) { this.name = value; }

    public boolean getDisponibility() { return disponibility; }

    public void setDisponibility(boolean value) {
        this.disponibility = value;
    }
}