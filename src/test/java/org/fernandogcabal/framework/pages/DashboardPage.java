package org.fernandogcabal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Class Declaration
public class DashboardPage extends BasePage {

    // Constructor
    public DashboardPage(WebDriver driver){
        super(driver);
    }

    // Dashboard visibility check
    // Locator stable and readable
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By PIMMenu =  By.xpath("//span[text()='PIM']");
    private By TimeMenu =  By.xpath("//span[text()='Time']");
    private By LeaveMenu =  By.xpath("//span[text()='Leave']");
    private By RecruitmentMenu =  By.xpath("//span[text()='Recruitment']");
    private By PerformanceMenu =  By.xpath("//span[text()='Performance']");
    private By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    // Navigation methods
    // Visibility check method
    public boolean isDashboardVisible() {
        return wait.waitForVisible(dashboardHeader).isDisplayed();
    }

    // Navigate to Admin
    public void goToAdmin() {
        wait.waitForClickable(adminMenu).click();
    }

    // Navigate to PIM
    public void goToPIM() {
        wait.waitForClickable(PIMMenu).click();
    } 

    // Navigate to Time
    public void goToTime() {
        wait.waitForClickable(TimeMenu).click();
    }

    // Navigate to Leave
    public void goToLeave() {
        wait.waitForClickable(LeaveMenu).click();
    }

    // Navigate to Recruitment
    public void goToRecruitment() {
        wait.waitForClickable(RecruitmentMenu).click();
    }

    // Navigate to Performance
    public void goToPerformance() {
        wait.waitForClickable(PerformanceMenu).click();
    }

    //Logout Method
    public void logout(){
        wait.waitForClickable(userDropdown).click();
        wait.waitForClickable(logoutLink).click();
    }

}
