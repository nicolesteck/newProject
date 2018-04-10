package edu.matc.controller;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/callApi"}
)
public class CallApi extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    ReadInConnections read = new ReadInConnections();
    read.readIn();
    RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
    dispatcher.forward(req, resp);


    }
}
