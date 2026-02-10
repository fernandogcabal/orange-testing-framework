package org.fernandogcabal.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.By;

// Class declaration
public class WaitHelper {

    // Fields 
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public WaitHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method 1: waitForVisible
    public WebElement waitForVisible(By locator){
        // Waits until element is visible in DOM and not hidden
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
                );
    }

    // Method 2: waitForClickable
    public WebElement waitForClickable(By locator) {
        // Means Visible, Enabled and not overlapped
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
                );
    }

    // Method 3: waitForUrlContains
    public boolean waitForUrlContains(String text){
        // Used for Login redirects, page transitions, SPA routing
        return wait.until(ExpectedConditions.urlContains(text));
    }

    

}

