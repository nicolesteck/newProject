package edu.matc.controller;


import edu.matc.util.PropertiesLoaderInterface;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

/**
 * The startup servlet, loaded right away, which places the properties file
 * into the servlet context so it can be reached throughout the application.
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/startup" },
        loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet implements PropertiesLoaderInterface {


    /**
     * The init method, run automatically on startup, loads the properties
     * from the Project 4 Properties file, gets the Servlet Context and
     * employee directory, and adds both to the Servlet Context.
     */
    public void init() throws ServletException {

        Properties properties = loadProperties("/annotator.properties");
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("annotatorProperties", properties);
        System.out.println(properties.toString());

    }
}