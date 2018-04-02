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



    @ManyToOne
    private User user;

    @Column(name="linkedIn_id")
    private String linkedInId;


    public Connection() {
    }

    public Connection(String interests, String notes, User user, String linkedInId) {

        this.interests = interests;
        this.notes = notes;
        this.user = user;
        this.linkedInId = linkedInId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        if (id != that.id) return false;
        if (interests != null ? !interests.equals(that.interests) : that.interests != null) return false;
        return notes != null ? notes.equals(that.notes) : that.notes == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (interests != null ? interests.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", interests='" + interests + '\'' +
                ", notes='" + notes + '\'' +
                ", user=" + user +
                ", linkedInId='" + linkedInId + '\'' +
                '}';
    }
}
