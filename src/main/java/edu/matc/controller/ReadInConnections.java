package edu.matc.controller;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.net.URLConnection;



public class ReadInConnections {

    public static void main(String[] args) {
        //hi
    }
        public void readIn() throws IOException {
          //  private final Logger logger = LogManager.getLogger(this.getClass());


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
               System.out.println(line);

            }
        }

    }