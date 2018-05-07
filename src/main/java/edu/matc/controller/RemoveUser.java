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
 * Complete removal of a user as directed by an administrator.
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/removeUser"}
)


public class RemoveUser extends HttpServlet {
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
        // Connect to the database and create a user object
        GenericDao<User> dao = new GenericDao<>(User.class);
        User user;

        // Retrieve the user by ID
        String id = req.getParameter("id");
        int intId = Integer.parseInt(id);
        user = dao.getById(intId);
        logger.info(id);

        // Delete the user and forward to a successful deletion JSP
        dao.delete(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userRemovalSuccess.jsp");
        dispatcher.forward(req, resp);
    }

}
