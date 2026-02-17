package org.fernandogcabal.framework.base;

import org.fernandogcabal.framework.drivers.BrowserType;
import org.fernandogcabal.framework.drivers.DriverFactory;
import org.fernandogcabal.framework.drivers.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fernandogcabal.framework.utils.ConfigReader;
import org.fernandogcabal.framework.utils.LogLevel;
import org.fernandogcabal.framework.utils.LoggerUtil;

import java.time.Duration;

public class BaseTest{


    protected WebDriver driver;

    //Sanity Test method
    //__sanityCheckBase = internal
    @Test
    public void __sanityCheckBaseTest(){
        System.out.println(">>> BASETEST TEST METHOD EXECUTED <<<");
    }

    //@BeforeMethod - test setup
    //runs before every @Test method
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        //DEBUG PRINT
        System.out.println(">>> BASETEST BEFOREMETHOD EXECUTED");

        //Logging: test start
        LoggerUtil.getInstance().log(LogLevel.INFO, "Starting test execution");

        //Create WebDriver (Factory Pattern)
        //Browser creation centralized
        driver = DriverFactory.createDriver(BrowserType.CHROME);

        //Driver configuration
        //Standard UI test setup
        driver.manage().window().maximize();
        //Explicit page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //GetUrl
        driver.get(ConfigReader.get("baseUrl"));

        //Store driver in DriveManager
        DriverManager.setDriver(driver);
    }

    //OpenBaseURL() helper
    //protected available for subclasses
    protected void openBaseUrl(){

        DriverManager.getDriver().get(ConfigReader.getInstance().get("baseUrl"));

    }

    //@AfterMethod - teardown
    //For browser cleanup
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        //Logging: test end
        LoggerUtil.getInstance().log(LogLevel.INFO, "Closing browser");

        //Close browser safely
        WebDriver driver = DriverManager.getDriver();
        if (driver != null){
            driver.quit();
        }

        //Clean thread context
        DriverManager.unload();

    }
}

