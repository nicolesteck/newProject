package edu.matc.persistence;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class ConnectionDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */
    private GenericDao<Connection> genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
       // logger.info("BeforeEach");
        genericDao = new GenericDao<>(Connection.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllConnectionsSuccess() {
        List<Connection> connections = (List<Connection>)genericDao.getAll();
        assertEquals(3, connections.size());
    }
    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User user = userDao.getById(1);
        Connection newCon = new Connection("Dogs","Likes dogs", user, "3241234", "John", "Trebek", "WPS");
        int id = genericDao.insert(newCon);
        assertNotEquals(0,id);
        Connection insertedCon = (Connection)genericDao.getById(id);
        assertEquals(newCon, insertedCon);

    }

    /**
     * Save or update.
     */
    @Test // Genericized
    void saveOrUpdate() {
        String newInterests = "Watching movies";
        Connection thisConnection = (Connection)genericDao.getById(3);
        thisConnection.setInterests(newInterests);
        genericDao.saveOrUpdate(thisConnection);
        Connection thatConnection = (Connection)genericDao.getById(3);
        assertEquals(thisConnection, thatConnection);
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<Connection> connections = (List<Connection>)genericDao.getByPropertyEqual("firstName", "Joe");
        assertNotNull(connections);
        assertEquals(1, connections.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<Connection> connections = (List<Connection>)genericDao.getByPropertyLike("firstName", "j");
        assertEquals(2, connections.size());
    }

}
