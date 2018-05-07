package edu.matc.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.io.*;

/**
 * The interface Properties loader interface.
 */
public interface PropertiesLoaderInterface {

    /**
     * Load properties properties.
     *
     * @param propertiesFilePath the properties file path
     * @return the properties
     */
    default Properties loadProperties(String propertiesFilePath)  {
        final Logger logger = LogManager.getLogger(this.getClass());

        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
           logger.error("Can't load the properties file" + ioException);
            ioException.printStackTrace();
            return null;
        } catch(Exception exception) {
            logger.error("Problem: " + exception);
            exception.printStackTrace();
            return null;
        }
        return properties;
    }
}