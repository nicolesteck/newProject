package edu.matc.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import edu.matc.entity.Connection;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.scribejava.core.model.Response;


import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

/**
 * The type Import connections.
 */
@WebServlet(
        name = "importConnections",
        urlPatterns = {"/importConnections"}
)

public class ImportConnections extends HttpServlet {
    /*
    private final Logger logger = LogManager.getLogger(this.getClass());



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            String jsonReturned = req.getQueryString();
            logger.info(jsonReturned);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/importConnections.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException se) {
            logger.error("ERROR: Servlet Exception " + se);
        }


    }
*/

}
