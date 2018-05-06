package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.ReadInConnections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * The servlet that initiates the API call
 */
@WebServlet(
        name="callApi",
        urlPatterns = {"/callApi"}
)
public class CallApi extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * *
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        int id = identifyUser(req, servletContext);
        Properties properties = (Properties)servletContext.getAttribute("annotatorProperties");
        ReadInConnections read = new ReadInConnections(id);
        Set<String> connectionsList = read.readIn(properties);
        servletContext.setAttribute("connections", connectionsList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/connectionsImported.jsp");
        dispatcher.forward(req, resp);


    }

    private int identifyUser(HttpServletRequest req, ServletContext servletContext) {
        String userVal = req.getRemoteUser();
        logger.info("userVal " + userVal + " in identifyUser");
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int id = localDao.getByPropertyLike("email", userVal).get(0).getId();
        logger.info("userId " + id + " in identifyUser");
        servletContext.setAttribute("userId", id);
        return id;

    }

}
