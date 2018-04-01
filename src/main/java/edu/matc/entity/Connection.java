package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;
//import java.util.Objects;

@Entity(name = "connections")
@Table(name="connections")
public class Connection {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="interests")
    private String interests;

    @Column(name="notes")
    private String notes;


    public Connection() {
    }

    public Connection(String interests, String notes) {
        this.interests = interests;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
