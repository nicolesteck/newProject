package edu.matc.entity;

import edu.matc.persistence.GenericDao;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Role.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getRoleById() {
        Role role = (Role)genericDao.getById(1);
        assertEquals("user", role.getRoleName());

    }

    @Test
    void getRoles() {
        List<Role> roles = (List)genericDao.getAll();
        assertEquals(1, roles.size());
    }

}