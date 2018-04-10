package edu.matc.controller;

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
    ReadInConnections read = new ReadInConnections();
    Set<String> connectionsList = read.readIn();
    servletContext = getServletContext();
    servletContext.setAttribute("connections", connectionsList);
    logger.info(" CONNECTIONS LIST:  [ FROM WITHIN CALLAPI ] " + connectionsList);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
    dispatcher.forward(req, resp);


    }
}
