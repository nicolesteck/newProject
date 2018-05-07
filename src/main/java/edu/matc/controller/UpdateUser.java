package edu.matc.controller;


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
 * * The servlet that collects a user's information
 * and then sends it on to the JSP where the admin can make
 * updates to their user's information.
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/updateUser"}
)

public class UpdateUser extends HttpServlet {

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
        GenericDao<User> dao = new GenericDao<>(User.class);

        // Retrieve the user's id from the request
        String id = req.getParameter("id");
        logger.debug("THE USER ID IS: " + id);

        // Set the user information into the request and forward to the JSP
        // where the user will make their changes.
        req.setAttribute("user", dao.getByPropertyEqual("id", id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateUser.jsp");
        logger.info("In the doGet of UpdateUser");
        dispatcher.forward(req, resp);
    }

}
