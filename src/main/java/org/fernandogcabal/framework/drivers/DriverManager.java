package org.fernandogcabal.framework.drivers;

import org.openqa.selenium.WebDriver;


//Class responsible for storing and retrieving WebDriver instance
public class DriverManager{

    //ThreadLocal - Each thread gets its own private copy of this var
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //SetDriver() method -- Stores the webdriver inside the curren thread
    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    //getDriver() method --Returns the WebDriver for the current thread
    public static WebDriver getDriver(){
        return driver.get();
    }

    //unload() method-- removes the driver reference from the current thread
    public static void unload(){
        driver.remove();
    }

}

