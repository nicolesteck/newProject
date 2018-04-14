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

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="company")
    private String company;

    @ManyToOne
    private User user;

    @Column(name="linkedIn_id")
    private String linkedInId;


    public Connection() {
    }

    public Connection(String interests, String notes, User user, String linkedInId, String firstName, String lastName, String company) {

        this.interests = interests;
        this.notes = notes;
        this.user = user;
        this.linkedInId = linkedInId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public Connection(User user, String firstName, String lastName, String company, String linkedInId) {

        this.user = user;
        this.linkedInId = linkedInId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

//    public Connection(String firstName, String lastName, String company, String linkedInId) {
//
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.company = company;
//        this.linkedInId = linkedInId;
//    }


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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLinkedInId() {
        return linkedInId;
    }

    public void setLinkedInId(String linkedInId) {
        this.linkedInId = linkedInId;
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
