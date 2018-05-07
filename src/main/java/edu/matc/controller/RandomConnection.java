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
 * Grab a random connection and output
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/randomConnection"}
)

public class RandomConnection extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param req the servlet request
     * @param resp the servlet response
     * @throws ServletException a servlet exception
     * @throws IOException an IO exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve a random connection
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
        req.setAttribute("connections", dao.getRandom());

        // Forward to the random connection JSP
        RequestDispatcher dispatcher = req.getRequestDispatcher("/randomConnection.jsp");
        dispatcher.forward(req, resp);
        logger.info("In the doGet of randomConnection");
    }

}
