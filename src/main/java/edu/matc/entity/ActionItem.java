package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "actionItems")
@Table(name="action_items")
public class ActionItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="date_created")
    public Date dateCreated;

    @Column(name="date_completed")
    public Date dateCompleted;

    @Column(name="action_item")
    public String actionItem;

    @Column(name="is_complete")
    public Boolean isComplete;

    @Column(name="user_id")
    public int userId;

    @Column(name="connections_id")
    public int connectionId;

    public ActionItem() {
    }

    public ActionItem(Date dateCreated, int connectionId, String actionItem, Boolean isComplete, int userId) {
        this.dateCreated = dateCreated;
        this.connectionId = connectionId;
        this.actionItem = actionItem;
        this.isComplete = isComplete;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
