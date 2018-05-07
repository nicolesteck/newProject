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
import java.io.IOException;


/**
 * The servlet to complete updates to the user object, as made by administrators
 * @author nicolesteck
 */
@WebServlet(
        urlPatterns = {"/completeUserUpdate"}
)

public class CompleteUserUpdate extends HttpServlet {

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
        // Access the user and role databases
        GenericDao<User> dao = new GenericDao<>(User.class);
        GenericDao<Role> roleDao = new GenericDao<>(Role.class);
        User user;
        Role role;

        // Retrieve id information from the servlet request and convert to an int
        String id = req.getParameter("id");
        int intId = Integer.parseInt(id);

        // Retrieve user information from the servlet request
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String roleName = req.getParameter("roleName");

        // Retrieve user and role information for the retrieved user
        user = dao.getById(intId);
        role = roleDao.getByPropertyEqualUserId(intId).get(0);

        // Set new/updated values to the user object
        user.setLastName(lastName);
        user.setEmail(email);
        user.setFirstName(firstName);
        role.setRoleName(roleName);

        // Set the user attribute, update the user data in the database,
        // and forward on.
        req.setAttribute("user", dao.getById(intId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("usersUpdated.jsp");
        dao.saveOrUpdate(user);
        logger.info("In the doGet of CompleteUserUpdate");
        dispatcher.forward(req, resp);



    }

}
