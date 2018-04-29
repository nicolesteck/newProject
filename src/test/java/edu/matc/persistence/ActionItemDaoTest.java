package edu.matc.persistence;

import edu.matc.entity.ActionItem;
import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class ActionItemDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * The Generic dao.
     */
    private GenericDao<ActionItem> genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
       // logger.info("BeforeEach");
        genericDao = new GenericDao<>(ActionItem.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllConnectionsSuccess() {
        List<ActionItem> actionItems = (List<ActionItem>)genericDao.getAll();
        assertEquals(3, actionItems.size());
    }
    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao<Connection> connectionDao = new GenericDao<>(Connection.class);
        Connection connection = connectionDao.getById(1);
        Date date = new Date();
        ActionItem ai = new ActionItem(date,2,"Call and invite to lunch", false, 1);
        int id = genericDao.insert(ai);
        assertNotEquals(0,id);
//        Connection insertedCon = (Connection)genericDao.getById(id);
//        assertEquals(newCon, insertedCon);

    }
//
//    /**
//     * Save or update.
//     */
//    @Test // Genericized
//    void saveOrUpdate() {
//        String newInterests = "Watching movies";
//        Connection thisConnection = (Connection)genericDao.getById(3);
//        thisConnection.setInterests(newInterests);
//        genericDao.saveOrUpdate(thisConnection);
//        Connection thatConnection = (Connection)genericDao.getById(3);
//        assertEquals(thisConnection, thatConnection);
//    }
//
//    /**
//     * Gets by property equal.
//     */
//    @Test
//    void getByPropertyEqual() {
//        List<Connection> connections = (List<Connection>)genericDao.getByPropertyEqual("firstName", "Joe");
//        assertNotNull(connections);
//        assertEquals(1, connections.size());
//    }
//
//    /**
//     * Gets by property like.
//     */
//    @Test
//    void getByPropertyLike() {
//        List<Connection> connections = (List<Connection>)genericDao.getByPropertyLike("firstName", "j");
//        assertEquals(2, connections.size());
//    }

}
