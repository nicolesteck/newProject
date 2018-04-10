package edu.matc.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.matc.entity.Connection;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/GetConnections")

public class GetConnections extends HttpServlet {
    /*
    private ServletContext servletContext;
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Connection> dao = new GenericDao<>(Connection.class);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getConnections() throws IOException {

        List<Connection> connectionsList = "https://my.api.mockaroo.com/Connections.json?key=9638ae60&redirect=localhost:8080/nsindieproject/home.jsp";
        // need to somehow make a call to the

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        String jsonToReturn = objectMapper.writeValueAsString(categoryResultSet);

        servletContext = getServletContext();

        servletContext.setAttribute("connections", connectionsList);

        return Response.status(200).entity(connectionsList).build();
    }
    */
}

