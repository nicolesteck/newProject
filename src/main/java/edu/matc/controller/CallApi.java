package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(
        urlPatterns = {"/callApi"}
)
public class CallApi extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ServletContext servletContext;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {



        String userVal = req.getRemoteUser();
        logger.info("~~~~~~~~~~~~~~~~~~~~~USERVAL: ~~~~~~~~~~~~~~~~~~~~~~~~~" + userVal + "~~(IN DOGET)~~~");

       // identifyUser(req);
        /* the below code was in another method but that broke it */
       // String userVal = req.getRemoteUser();
        logger.info("~~~~~~~~~~~~~~~~~~~~~USERVAL: ~~~~~~~~~~~~~~~~~~~~~~~~~" + userVal + "~~(IN ID USER)[jk]~~~");
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int id = localDao.getByPropertyLike("email", userVal).get(0).getId();
        logger.info("~~~~~~~~~~~~~~~~~~~~~USER ID: ~~~~~~~~~~~~~~~~~~~~~~~~~" + id + "~~~~~");
        servletContext = getServletContext();
        servletContext.setAttribute("userId", id);


        ReadInConnections read = new ReadInConnections(id);
        Set<String> connectionsList = read.readIn();
    servletContext.setAttribute("connections", connectionsList);
    logger.info(" CONNECTIONS LIST:  [ FROM WITHIN CALLAPI ] " + connectionsList);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
    dispatcher.forward(req, resp);


    }

   /* public int identifyUser(HttpServletRequest req, ServletContext servletContext) {
        String userVal = req.getRemoteUser();
        logger.info("~~~~~~~~~~~~~~~~~~~~~USERVAL: ~~~~~~~~~~~~~~~~~~~~~~~~~" + userVal + "~~(IN ID USER)~~~");
        GenericDao<User> localDao = new GenericDao<>(User.class);
        int id = localDao.getByPropertyLike("email", userVal).get(0).getId();
        logger.info("~~~~~~~~~~~~~~~~~~~~~USER ID: ~~~~~~~~~~~~~~~~~~~~~~~~~" + id + "~~~~~");
        servletContext.setAttribute("userId", id);
        return id;

    }
    */
}
