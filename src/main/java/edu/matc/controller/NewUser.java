package edu.matc.controller;

//import edu.matc.entity.Role;
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
import java.io.IOException;


/**
 * The user creation servlet
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/newUser"}
)


public class NewUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *
     * @param req the servlet request
     * @param resp the servlet response
     * @throws ServletException a servlet exception
     * @throws IOException an I/O exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create a new user object
        User user = new User();

        // Populate the new user object with the values entered
        // into the form (retrieved from the request)
        user.setEmail(req.getParameter("email"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));

        // Create a new role object and set the role as user
        // (New users can never have the role of administrator)
        Role role = new Role();
        role.setUser(user);
        role.setRoleName("user");
        role.setEmail(req.getParameter("email"));

        // Add the role to the user
        user.addRole(role);

        // Add the new user. Welcome to the family, new user!
        GenericDao<User> dao = new GenericDao<>(User.class);
        logger.info("(NEWUSER) USER INFO: " + user);
        dao.insert(user);

        // Forward to the new-user-specific index, which welcomes the
        // user and prompts them to log in
        RequestDispatcher dispatcher = req.getRequestDispatcher("/newUserIndex.jsp");
        dispatcher.forward(req, resp);
    }

}
