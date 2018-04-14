package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Connection;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import java.util.Properties;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.net.URLConnection;
import java.util.*;


public class ReadInConnections {
    private final Logger logger = LogManager.getLogger(this.getClass());
    User user;
    public static void main(String args) {
        //hi
    }
         Set<String> readIn() throws IOException {
          //  private final Logger logger = LogManager.getLogger(this.getClass());

            Set<String> connectionsList = new HashSet<String>();
            // Make a URL to the web page
            URL url = new URL("\n" +
                    "https://my.api.mockaroo.com/500_connections.json?key=94ce3ab0");

            // Get the input stream through URL Connection
            URLConnection con = url.openConnection();
            InputStream is =con.getInputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
           // ObjectMapper mapper;
            int i = 0;


            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[0]; // 004
                String lastName = parts[1]; // 034556
                String company = parts[2];
                String linkedInId = parts[3];
               // int userId = (int)servletContext.getAttribute("userId");

            //    mapper = new ObjectMapper();
                connectionsList.add(line);
                Connection connection;
                if (i>0) {
                    logger.info(line);
                 //   mapper.readValue("{" + line + "}", Connection.class);
                    connection = new Connection(user, firstName, lastName, company, linkedInId);
//                    logger.info("---------");
//                    logger.info("user: " + user.getEmail());
//                    logger.info("first name: " + firstName);
//                    logger.info("last name: " + lastName);
//                    logger.info("company: " + company);
//                    logger.info("linkedInId" + linkedInId);
                    GenericDao<Connection> localDao = new GenericDao<>(Connection.class);
                    localDao.insert(connection);
                }
                i++;


            }

            return connectionsList;
        }

        public User findUser(int id) {
            GenericDao<User> localDao = new GenericDao<>(User.class);
            user = localDao.getById(id);
        return user;
        }

        public ReadInConnections(int id) {
            user = findUser(id);
        }


    }