package edu.matc.persistence;

import edu.matc.entity.ActionItem;
import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    private GenericDao<Connection> connectionDao;
    private GenericDao<User> userDao;

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
    void getAllActionItemsSuccess() {
        List<ActionItem> actionItems = (List<ActionItem>)genericDao.getAll();
        assertEquals(2, actionItems.size());
    }
    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao<Connection> connectionDao = new GenericDao<>(Connection.class);
        Connection connection = connectionDao.getById(1);
        Date date = new Date();
        ActionItem ai = new ActionItem(date,connection,"Call and invite to lunch", false, 1);
        int id = genericDao.insert(ai);
        assertNotEquals(0,id);

    }

    /**
     * Save or update.
     */
    @Test // Genericized
    void saveOrUpdate() {
        ActionItem thisAi = (ActionItem)genericDao.getById(1);
        thisAi.setComplete(true);
        genericDao.saveOrUpdate(thisAi);
        ActionItem thatAi = (ActionItem)genericDao.getById(1);
        logger.debug("this: " + thisAi);
        logger.debug("that " + thatAi);
        assertEquals(thisAi, thatAi);
    }
//
    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<ActionItem> actionItems = (List<ActionItem>)genericDao.getByPropertyEqual("isComplete", false);
        assertNotNull(actionItems);
        assertEquals(1, actionItems.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<ActionItem> actionItems = (List<ActionItem>)genericDao.getByPropertyLike("actionItem", "call");
        assertEquals(1, actionItems.size());
    }

    @Test
    void getIdSuccess() {
        ActionItem thisAi = (ActionItem)genericDao.getById(1);
        int id = thisAi.getId();
        assertEquals(1, id);
    }

    @Test
    void setIdSuccess() {
        ActionItem thisAi = (ActionItem)genericDao.getById(1);
        int id = 17;
        thisAi.setId(id);
        assertEquals(17, id);
    }

    @Disabled
    @Test
    void getByPropertyEqualActionItemTestSuccess() {
        connectionDao = new GenericDao<>(Connection.class);
      //  userDao = new GenericDao<>(User.class);
        List<Connection> connections = connectionDao.getByPropertyEqual("lastName", "Goodall");
        assertEquals("Goodall", connections.get(0).getLastName());
        Connection connection = connections.get(0);
        int conId = connection.getId();
        User user = connection.getUser();
        int userId = user.getId();
        List<ActionItem> aiList = genericDao.getByPropertyEqualActionItem(conId);
        assertEquals(1, aiList.size());

    }

}
