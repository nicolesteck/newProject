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
        urlPatterns = {"/removeUser"}
)




public class RemoveUser extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> dao = new GenericDao<>(User.class);

        User user;

        String id = req.getParameter("id");
        int intId = Integer.parseInt(id);
        user = dao.getById(intId);
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
        dao.delete(user);


       // req.setAttribute("Status", firstName + " " + lastName + " has been removed from your database.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/removalSuccess.jsp");

        dispatcher.forward(req, resp);


    }

}
