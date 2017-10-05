package pages;

import globals.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "fname")
    private WebElement firstNameField;

    @FindBy(name = "lname")
    private WebElement lastNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "passwordConfirm")
    private WebElement confirmPasswordField;

    @FindBy(name = "role")
    private WebElement roleSelect;

    private Select roleDropdown = new Select(roleSelect);

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    public LoggedInPage registerNewUser(User user){
        nameField.sendKeys(user.getUsername());
        firstNameField.sendKeys(user.getfName());
        lastNameField.sendKeys(user.getlName());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
        roleDropdown.selectByVisibleText(user.getRole());
        registerButton.click();
        return new LoggedInPage();
    }

}
