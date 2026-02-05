package org.fernandogcabal.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



//Purpose create a properly configured WebDriver instance for a given browser
public class DriverFactory{

    //The factory method
    public static WebDriver createDriver(BrowserType browser){

        //Browser Selection with a switch
        switch (browser){
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); // headless
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage"); // use /tmp instead of /dev/shm
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                return new ChromeDriver(options);
        }
    }

}
