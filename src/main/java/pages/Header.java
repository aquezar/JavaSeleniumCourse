package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage{
    @FindBy(className = "welcome")
    private WebElement loggedInUserName;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(linkText = "My applications")
    private WebElement myApplicationsLink;

    @FindBy(linkText = "Ajax test page")
    private WebElement ajaxTestPageLink;

    @FindBy(linkText = "JS test page")
    private WebElement jsTestPageLink;


    public String getLoggedInUserNameText(){
        return loggedInUserName.getText();
    }

    public LoginPage clickLogoutLink(){
        logoutLink.click();
        return new LoginPage();
    }

    public MyAppsPage clickMyApplicationsLink(){
        myApplicationsLink.click();
        return new MyAppsPage();
    }

    public boolean isMyApplicationsLinkPresent(){
        try{
            if (myApplicationsLink.isDisplayed())
                System.out.println("My applications link is present");
        }
        catch (NoSuchElementException ex){
            System.out.println("My application link is not available");
            return false;
        }
        return true;
    }

    public AjaxCalcPage clickAjaxTestPageLink(){
        ajaxTestPageLink.click();
        return new AjaxCalcPage();
    }

    public JSTestPage clickJSTestPageLink(){
        jsTestPageLink.click();
        return new JSTestPage();
    }

}
