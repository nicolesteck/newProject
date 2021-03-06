package edu.matc.util;

import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


/**
 * The class that completes the business logic for reading
 * connections in and parsing them into POJOs
 * @author nicolesteck
 */
public class ReadInConnections {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The User.
     */
    private User user;

    /**
     * Read in set.
     *
     * @param properties the properties
     * @return the set
     * @throws IOException the io exception
     */
    public Set<String> readIn(Properties properties) throws IOException {
        //  private final Logger logger = LogManager.getLogger(this.getClass());

        Set<String> connectionsList = new HashSet<>();
        // Make a URL to the web page
        String apiUrl = properties.getProperty("connectionApi");
        URL url = new URL(apiUrl);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line; //= null;
        int i = 0;


        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String company = parts[3];
            String linkedInId = parts[2];
            connectionsList.add(line);
            Connection connection;
            if (i > 0) {
                logger.info(line);
                connection = new Connection(user, firstName, lastName, company, linkedInId);
                GenericDao<Connection> localDao = new GenericDao<>(Connection.class);
                localDao.insert(connection);
            }
            i++;


        }

        return connectionsList;
    }

    private User findUser(int id) {
        GenericDao<User> localDao = new GenericDao<>(User.class);
        user = localDao.getById(id);
        return user;
    }

    /**
     * Instantiates a new Read in connections.
     *
     * @param id the id
     */
    public ReadInConnections(int id) {
        user = findUser(id);
    }


}