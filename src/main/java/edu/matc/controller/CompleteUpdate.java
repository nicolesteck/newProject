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
        urlPatterns = {"/completeUpdate"}
)


public class CompleteUpdate extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);

        Connection connection;

        String linkedInId = (String)req.getParameter("linkedInId");
        logger.debug("LINKED IN ID IN COMPLETE UPDATE: " + linkedInId);
        String firstName = (String)req.getParameter("firstName");
        String lastName = (String)req.getParameter("lastName");
        String company = (String)req.getParameter("company");
        String interests = (String)req.getParameter("interests");
        String notes = (String)req.getParameter("notes");
        connection = dao.getByPropertyEqual("linkedInId", linkedInId).get(0);
        connection.setLastName(lastName);
        connection.setInterests(interests);
        connection.setFirstName(firstName);
        connection.setCompany(company);
        connection.setNotes(notes);


        req.setAttribute("connection", dao.getByPropertyEqual("linkedInId", linkedInId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dao.saveOrUpdate(connection);
        logger.info("In the doGet of CompleteUpdate");
        dispatcher.forward(req, resp);


    }

}
