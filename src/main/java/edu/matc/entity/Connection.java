package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Connection.
 */
@Entity(name = "connection")
@Table(name="connection")
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

    @OneToMany(mappedBy="connection", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
    private Set<ActionItem> actionItems = new HashSet<>();

    @Column(name="linkedIn_id")
    private String linkedInId;


    /**
     * Instantiates a new Connection.
     */
    public Connection() {
    }

    /**
     * Instantiates a new Connection.
     *
     * @param interests  the interests
     * @param notes      the notes
     * @param user       the user
     * @param linkedInId the linked in id
     * @param firstName  the first name
     * @param lastName   the last name
     * @param company    the company
     */
    public Connection(String interests, String notes, User user, String linkedInId, String firstName, String lastName, String company) {

        this.interests = interests;
        this.notes = notes;
        this.user = user;
        this.linkedInId = linkedInId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    /**
     * Instantiates a new Connection.
     *
     * @param user       the user
     * @param firstName  the first name
     * @param lastName   the last name
     * @param company    the company
     * @param linkedInId the linked in id
     */
    public Connection(User user, String firstName, String lastName, String company, String linkedInId) {

        this.user = user;
        this.linkedInId = linkedInId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets interests.
     *
     * @return the interests
     */
    public String getInterests() {
        return interests;
    }

    /**
     * Sets interests.
     *
     * @param interests the interests
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {return user;}

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {this.user = user; }

    /**
     * Gets linked in id.
     *
     * @return the linked in id
     */
    public String getLinkedInId() {
        return linkedInId;
    }

    /**
     * Sets linked in id.
     *
     * @param linkedInId the linked in id
     */
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
