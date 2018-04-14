package edu.matc.controller;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type All connections.
 */
@WebServlet(
        urlPatterns = {"/allConnections"}
)

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */


public class AllConnections extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        req.setAttribute("connections", dao.getAll());
        logger.debug("USERdao.getAll what is this?: " + userDao.getAll().get(0));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allConnections.jsp");
        logger.debug(resp);
       // dispatcher.forward(req, resp);

        logger.info("In the doGet of allConnections");
    }

}
