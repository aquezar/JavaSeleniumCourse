package pages;

import globals.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverManager;

public class LoginPage extends BasePage {

    @FindBy(id = "j_username")
    private WebElement usernameField;

    @FindBy(id = "j_password")
    private  WebElement passwordField;

    @FindBy(xpath = "//input[contains(@value, 'Login')]")
    private WebElement loginButton;

    @FindBy(linkText = "Register as a new user")
    private WebElement registerNewUserLink;

    @FindBy(className = "flash")
    private WebElement errorLoginMessage;

    public String getErrorLoginMessageText(){
        return errorLoginMessage.getText();
    }

    public LoggedInPage LogIn(User user){
        if (WebDriverManager.isBasicAuthenticationEnabled()){
            WebDriverManager.authenticateBasic(user);
        }
        else if (!WebDriverManager.isBasicAuthenticationEnabled()) {
            usernameField.sendKeys(user.getUsername());
            passwordField.sendKeys(user.getPassword());
            loginButton.click();
        }
        return new LoggedInPage();
    }

    public RegisterPage openRegisterPage(){
        registerNewUserLink.click();
        return new RegisterPage();
    }

}
