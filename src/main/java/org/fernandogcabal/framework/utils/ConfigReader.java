package org.fernandogcabal.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader{

    //Singleton Setup eager initialization
    private static final ConfigReader INSTANCE = new ConfigReader();
    private final Properties properties = new Properties();

    //Private constructor
    private ConfigReader(){

        //Environment Selection --mvn test -Denv=prod
        //Default qa
        String env = System.getProperty("env","qa");
        String configFile = "config/" + env + ".properties";

        //Logger Usage - Reuses custon Logger
        LoggerUtil logger = LoggerUtil.getInstance();

        //Load file from classpath
        //Loads form src/main/resources
        try(InputStream is = getClass()
            .getClassLoader()
            .getResourceAsStream(configFile)){

            //Missing file -- handling
            if(is == null){
                logger.log(LogLevel.ERROR, "Configuration file not found" + configFile);
                throw new RuntimeException("Missing config file: " + configFile);
            }

            //Load Properties
            properties.load(is);

            //Success log
            logger.log(LogLevel.INFO,"Loaded configuration file: " + configFile);

        }
        catch(Exception e){
            //Error Handling
            logger.log(LogLevel.ERROR, "Failed to load configuration file: " + configFile);
            throw new RuntimeException("Failed to load config", e);
        }

    }

    //Singleton access method
    public static ConfigReader getInstance(){
        return INSTANCE;
    }

    //Get Config value
    public String get(String key){

        //Access config by key
        String value =  properties.getProperty(key);

        //Missing key - handdler
        if(value == null){
            LoggerUtil.getInstance()
                .log(LogLevel.ERROR, "Missing configuration key: " + key);
            throw new RuntimeException("Missing configuration key: " + key);
        }

        return value;
    }

}
