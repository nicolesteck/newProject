package edu.matc.controller;

import edu.matc.entity.Connection;
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
        urlPatterns = {"/updateUser"}
)

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */


public class UpdateUser extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        GenericDao<User> dao = new GenericDao<>(User.class);

        String id = (String)req.getParameter("id");
        int intId = Integer.parseInt(id);
        logger.debug("THE USER ID IS: " + id);

        req.setAttribute("user", dao.getByPropertyEqual("id", id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateUser.jsp");
        logger.info("In the doGet of UpdateConnection");
        dispatcher.forward(req, resp);


    }

}
