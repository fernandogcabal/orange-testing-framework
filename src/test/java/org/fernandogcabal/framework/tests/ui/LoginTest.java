package org.fernandogcabal.framework.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.fernandogcabal.framework.base.BaseTest;
import org.fernandogcabal.framework.pages.LoginPage;
import org.fernandogcabal.framework.pages.DashboardPage;

import org.fernandogcabal.framework.utils.ConfigReader;

// Class declaration
public class LoginTest extends BaseTest {

   
    @Test
    public void validLoginShouldNavigateToDashboard(){
        String username = ConfigReader.get("user");
        String password = ConfigReader.get("password");
  
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page did not load properly");
        
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardVisible(),
                "Dashboard is not visible after login");
    }

    @Test
    public void invalidLoginTest(){
        String username = ConfigReader.get("user");
        
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isPageLoaded(), 
                "Login page did not load properly");

        loginPage.login(username,"123");

        Assert.assertTrue(loginPage.isErrorDisplayed()
                , "Error is not displayed");

    }

}
