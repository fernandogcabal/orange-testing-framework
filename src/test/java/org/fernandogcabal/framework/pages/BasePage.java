package org.fernandogcabal.framework.pages;

import org.openqa.selenium.WebDriver;
import org.fernandogcabal.framework.base.WaitHelper;

// It is the parent of all Page Objects
// Abstract mean can not be instantiate directly only extended
public abstract class BasePage{


    // Protected Fields
    // Accessible by subclasses
    protected WebDriver driver;
    protected WaitHelper wait;

    // Constructor
    public BasePage(WebDriver driver){

        this.driver = driver;
        this.wait =  new WaitHelper(driver);
    }

}
