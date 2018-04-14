package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Connection;
import edu.matc.entity.User;
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


public class ReadInConnections {
    private final Logger logger = LogManager.getLogger(this.getClass());

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
            getUserId();

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[0]; // 004
                String lastName = parts[1]; // 034556
                String company = parts[2];
                String linkedInId = parts[3];
            //    mapper = new ObjectMapper();
                connectionsList.add(line);
                Connection connection;
                if (i>0) {
                  //  logger.info(line);
                 //   mapper.readValue("{" + line + "}", Connection.class);
                    connection = new Connection(firstName, lastName, company, linkedInId);
                    logger.info("---------");
                    logger.info("first name: " + firstName);
                    logger.info("last name: " + lastName);
                    logger.info("company: " + company);
                    logger.info("linkedInId" + linkedInId);
                }
                i++;


            }

            return connectionsList;
        }

        public void getUserId() {
        Properties properties = new Properties();
        User user;
        String userName = properties.getProperty(user.name);
        int userId =
        }

    }