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

public class ConnectionDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * The Generic dao.
     */
    GenericDao<Connection> genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        logger.info("BeforeEach");
        genericDao = new GenericDao<>(Connection.class);
        Database database = Database.getInstance();
        logger.info("hi");
        database.runSQL("generatetest.sql");

    }

    /**
     * Gets all users success.
     */
    @Test
    void getAllConnectionsSuccess() {
        List<Connection> connections = (List<Connection>)genericDao.getAll();
        assertEquals(4, connections.size());
    }
}
