package edu.matc.controller;

import edu.matc.entity.Connection;
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


@WebServlet(
        urlPatterns = {"/completeUserUpdate"}
)

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */


public class CompleteUserUpdate extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> dao = new GenericDao<>(User.class);
        GenericDao<Role> roleDao = new GenericDao<>(Role.class);

        User user;
        Role role;

        String id = (String)req.getParameter("id");
        int intId = Integer.parseInt(id);
        String firstName = (String)req.getParameter("firstName");
        String lastName = (String)req.getParameter("lastName");
        String email = (String)req.getParameter("email");
        String roleName = (String)req.getParameter("roleName");
        user = dao.getById(intId);
        role = roleDao.getByPropertyEqualUserId(intId).get(0);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setFirstName(firstName);
        role.setRoleName(roleName);


        req.setAttribute("user", dao.getById(intId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dao.saveOrUpdate(user);
        logger.info("In the doGet of CompleteUserUpdate");
        dispatcher.forward(req, resp);


    }

}
