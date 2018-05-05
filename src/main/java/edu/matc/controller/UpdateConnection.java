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
        urlPatterns = {"/updateConnection"}
)


public class UpdateConnection extends HttpServlet {



    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
        GenericDao<Connection> dao = new GenericDao<>(Connection.class);
       // GenericDao<User> userDao = new GenericDao<>(User.class);
//        req.setAttribute("connections", dao.getAll());
//        logger.debug("USERdao.getAll what is this?: " + userDao.getAll().get(0));
//
//        logger.debug(resp);
//        logger.debug("RESPONSE HEADER NAMES: "  + resp.getHeaderNames());
//        // logger.debug("RESPONSE HEADERS: " + resp.getHeader());
//        logger.debug("RESPONSE STATUS: " + resp.getStatus());
//        logger.debug("REQUEST QUERY STRING: " + req.getQueryString());
//
        String linkedInId = req.getParameter("linkedInId");
        logger.debug("THE LINKEDIN ID IS: " + linkedInId);

        req.setAttribute("connection", dao.getByPropertyEqual("linkedInId", linkedInId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateInterests.jsp");
        logger.info("In the doGet of UpdateConnection");
        dispatcher.forward(req, resp);


    }

}
