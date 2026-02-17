package org.fernandogcabal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// The abstractions gives: driver and wait
public class LoginPage extends BasePage{

    // Constructor
    // Test -> Page, Page -> Base Page, BasePage -> WaitHelper
    public LoginPage(WebDriver driver){
        super(driver);
    }

    // Define locators
    private By usernameInput = By.name("username");
    private By passwordInput =  By.name("password");
    private By loginButton = By.cssSelector(".oxd-button");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");

    // Page Actions (behavior, not Selenium)
   public void enterUsername(String username){
       wait.waitForVisible(usernameInput).sendKeys(username);
   } 

   public void enterPassword(String password){
       wait.waitForVisible(passwordInput).sendKeys(password);
   }

   public void clickLogin(){
       wait.waitForClickable(loginButton).click();
   }

   // Getter Method: wait for the error appears
   public String getErrorMessage(){
       return wait.waitForVisible(errorMessage).getText();
   }

   // Error presence check
   public boolean isErrorDisplayed(){
       return wait.waitForVisible(errorMessage).isDisplayed();
   }

    
   // High-level page behavior
   public void login(String user, String pass){
       enterUsername(user);
       enterPassword(pass);
       clickLogin();
   }


   // Validates existence
   public boolean isPageLoaded(){
        return wait.waitForVisible(usernameInput).isDisplayed();
   }

 }
