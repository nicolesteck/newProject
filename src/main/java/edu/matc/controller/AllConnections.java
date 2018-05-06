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
import java.util.List;


/**
 * A servlet to retrieve all connections tied to the current user
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/allConnections"}
)

public class AllConnections extends HttpServlet {


    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param req the servlet request
     * @param resp the servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Identify current user
        String userVal = req.getRemoteUser();
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int userId = localDao.getByPropertyLike("email", userVal).get(0).getId();
        String userIdString = String.valueOf(userId);

        // Retrieve all Connections related to current user and load into ServletRequest
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
        req.setAttribute("connections", dao.getByPropertyEqualUserId(userId));
        List<Connection> connections = dao.getByPropertyEqualUserId(userId);
        logger.debug(connections);
        logger.debug("IN ALL CONNECTIONS: user id is " + userIdString);
        logger.debug("ConnectionDao.getByPropertyEqualUserId what is this?: " + dao.getByPropertyEqualUserId(userId));

        //Forward to the connection viewer JSP
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allConnections.jsp");
        dispatcher.forward(req, resp);
        logger.info("In the doGet of allConnections");
    }

}
