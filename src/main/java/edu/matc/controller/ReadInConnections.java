package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
                    "https://my.api.mockaroo.com/Connections.json?key=9638ae60");

            // Get the input stream through URL Connection
            URLConnection con = url.openConnection();
            InputStream is =con.getInputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;


            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
               connectionsList.add(line);
               logger.info(line);

            }

            return connectionsList;
        }

    }