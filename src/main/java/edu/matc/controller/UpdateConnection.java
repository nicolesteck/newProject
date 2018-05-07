package edu.matc.controller;

import edu.matc.entity.Connection;
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
 * The servlet that collects a connection's information
 * and then sends it on to the JSP where the user can make
 * updates to their connection's information.
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/updateConnection"}
)


public class UpdateConnection extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param req the servlet request
     * @param resp the servlet response
     * @throws ServletException a servlet exception
     * @throws IOException an I/O exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Connect to the database
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);

        // Retrieve the connection information from the request
        String linkedInId = req.getParameter("linkedInId");
        logger.debug("THE LINKEDIN ID IS: " + linkedInId);

        // Set the connection information into the request and forward
        // to the JSP where the updates will be made
        req.setAttribute("connection", dao.getByPropertyEqual("linkedInId", linkedInId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateInterests.jsp");
        logger.info("In the doGet of UpdateConnection");
        dispatcher.forward(req, resp);

    }

}
