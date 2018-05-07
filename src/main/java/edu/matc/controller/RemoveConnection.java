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
 * A servlet that completes the removal of a connection
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/removeConnection"}
)


public class RemoveConnection extends HttpServlet {

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

        // Access the database and create a connection object
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
        Connection connection;

        // Retrieve the connection information using the linkedInId
        String linkedInId = req.getParameter("linkedInId");
        connection = dao.getByPropertyEqual("linkedInId", linkedInId).get(0);
        String firstName = connection.getFirstName();
        String lastName = connection.getLastName();
        logger.info("name: " + firstName + " " + lastName);

        // Complete the deletion and forward to a page confirming successful removal
        dao.delete(connection);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/removalSuccess.jsp");
        dispatcher.forward(req, resp);

    }

}
