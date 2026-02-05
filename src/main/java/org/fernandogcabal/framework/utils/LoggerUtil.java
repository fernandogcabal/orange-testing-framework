package org.fernandogcabal.framework.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil{

    //Singleton Intance
    private static LoggerUtil instance;

    //Date Formatter 2026-02-04 14:23:11.482
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    //Log threshold, controls minimum severity to log
    private LogLevel currentThreshold =  LogLevel.INFO;

    //Private Contructor -- part of the singleton implementation
    private LoggerUtil(){}

    /*Singleton access method
     * Creates the logger once
     * Returns the same instance every time
     * synchronized makes it thread-safe
    */
    public static synchronized LoggerUtil getInstance() {

        if (instance == null){
            instance = new LoggerUtil();
        }
        return instance;
    }

    //Log method
    public void log(LogLevel level, String message){

        //Log Filtering
        if(level.ordinal()>= currentThreshold.ordinal()){

            //Timestamp creation
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(FORMATTER);

            //Final log message 2026-02-04 14:23:11.482 [INFO] User logged in
            String outputMessage = String.format("%s [%s] %s", formattedDate, level.name(), message);

            //Output Destination
            switch (level) {
                case INFO, DEBUG -> System.out.println(outputMessage);
                case WARN, ERROR -> System.out.println(outputMessage);
            }

        }
    }

    //Changing the threshold
    public void setTreshold(LogLevel level){
        this.currentThreshold = level;
    }

}
