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
 * The type All connections.
 */
@WebServlet(
        urlPatterns = {"/allConnections"}
)




public class AllConnections extends HttpServlet {
//private ServletContext servletContext;


    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  servletContext = getServletContext();
        String userVal = req.getRemoteUser();
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int userId = localDao.getByPropertyLike("email", userVal).get(0).getId();
        //int userId = (int)servletContext.getAttribute("userId");
        String userIdString = String.valueOf(userId);
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
        //req.setAttribute("connections", dao.getAll());
        req.setAttribute("connections", dao.getByPropertyEqualUserId(userId));
     //   User user = localDao.getById(userId);
         List<Connection> connections = dao.getByPropertyEqualUserId(userId);
         logger.debug(connections);

       //  List<ActionItem> actionItems = aiDao.getByPropertyEqualActionItem(connectionId, userId);
        logger.debug("IN ALL CONNECTIONS: user id is " + userIdString);
        logger.debug("ConnectionDao.getByPropertyEqualUserId what is this?: " + dao.getByPropertyEqualUserId(userId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allConnections.jsp");
        dispatcher.forward(req, resp);

        logger.info("In the doGet of allConnections");
    }

}
