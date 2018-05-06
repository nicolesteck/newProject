package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/**
 * The type Action item.
 */
@Entity(name = "actionItems")
@Table(name="action_items")
public class ActionItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="date_created")
    private Date dateCreated;


    @Column(name="action_item")
    private String actionItem;

    @Column(name="is_complete")
    private Boolean isComplete;

    /**
     * The User id.
     */
    @Column(name="user_id")
    public int userId;


    @ManyToOne
    @JoinColumn(name="connection_id")
    private Connection connection;


    /**
     * Instantiates a new Action item.
     */
    public ActionItem() {
    }

    /**
     * Instantiates a new Action item.
     *
     * @param dateCreated the date created
     * @param connection  the connection
     * @param actionItem  the action item
     * @param isComplete  whether the item is complete
     * @param userId      the user id
     */
    public ActionItem(Date dateCreated, Connection connection, String actionItem, Boolean isComplete, int userId) {
        this.dateCreated = dateCreated;
        this.connection = connection;
        this.actionItem = actionItem;
        this.isComplete = isComplete;
        this.userId = userId;
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

    private Date getDateCreated() {
        return dateCreated;
    }


    private String getActionItem() {
        return actionItem;
    }

    /**
     * Gets complete.
     *
     * @return the complete
     */
    public Boolean getComplete() {
        return isComplete;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    /**
     * Sets action item.
     *
     * @param actionItem the action item
     */
    public void setActionItem(String actionItem) {
        this.actionItem = actionItem;
    }

    /**
     * Sets complete.
     *
     * @param complete the complete
     */
    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Sets connection.
     *
     * @param connection the connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets connection id.
     *
     * @param connection the connection
     * @return the connection id
     */
    public int getConnectionId(Connection connection) {return connection.getId();}

    //public void setConnectionId() {this.connection.getId() = connection.getId(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionItem)) return false;

        ActionItem that = (ActionItem) o;

        if (getId() != that.getId()) return false;
        if (getUserId() != that.getUserId()) return false;
        if (getDateCreated() != null ? !getDateCreated().equals(that.getDateCreated()) : that.getDateCreated() != null)
            return false;
        if (getActionItem() != null ? !getActionItem().equals(that.getActionItem()) : that.getActionItem() != null)
            return false;
        if (isComplete != null ? !isComplete.equals(that.isComplete) : that.isComplete != null) return false;
        return getConnection() != null ? getConnection().equals(that.getConnection()) : that.getConnection() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getDateCreated() != null ? getDateCreated().hashCode() : 0);
        result = 31 * result + (getActionItem() != null ? getActionItem().hashCode() : 0);
        result = 31 * result + (isComplete != null ? isComplete.hashCode() : 0);
        result = 31 * result + getUserId();
        result = 31 * result + (getConnection() != null ? getConnection().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionItem{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", actionItem='" + actionItem + '\'' +
                ", isComplete=" + isComplete +
                ", userId=" + userId +
                ", connection=" + connection +
                '}';
    }
}
