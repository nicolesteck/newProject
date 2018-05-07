package edu.matc.controller;

import edu.matc.entity.Role;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The login servlet that accepts user information from the
 * newly-logged-in user and sets it into the session to be
 * retrieved for dynamic navigation
 * @author nicolesteck
 */
@WebServlet(
        name="login",
        urlPatterns = {"/login"}
)
public class LogIn extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param req the servlet request
     * @param resp the servlet response
     * @throws IOException an I/O exception
     * @throws ServletException a servlet exception
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session;

        // Retrieve the username value from the servlet request, and
        // find the user id associated with that username
        String userVal = req.getRemoteUser();
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int id = localDao.getByPropertyLike("email", userVal).get(0).getId();

        // Retrieve the user and role object associated with the retrieved user id
        User user = localDao.getById(id);
        Role role = user.getRoles().iterator().next();
        int roleId = role.getId();
        String roleName = role.getRoleName();
        logger.info("roleId: " + roleId + " and roleName: " + roleName);

        // Set the user and role information into the session so that the navigation
        // bar can display appropriate links for the user's role level
        session = req.getSession();
        session.setAttribute("userId", id);
        session.setAttribute("role", roleName);

        // Send the user home
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }
}
