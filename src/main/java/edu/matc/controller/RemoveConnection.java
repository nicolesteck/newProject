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


@WebServlet(
        urlPatterns = {"/removeConnection"}
)




public class RemoveConnection extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);

        Connection connection;

        String linkedInId = (String)req.getParameter("linkedInId");
        connection = dao.getByPropertyEqual("linkedInId", linkedInId).get(0);
        String firstName = connection.getFirstName();
        String lastName = connection.getLastName();
        dao.delete(connection);


       // req.setAttribute("Status", firstName + " " + lastName + " has been removed from your database.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/removalSuccess.jsp");

        dispatcher.forward(req, resp);


    }

}
