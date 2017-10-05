package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverManager;

public class BasePage extends PageFactory {

    private String currentWindow = WebDriverManager.driver.getWindowHandle();

    @FindBy(css = "body")
    public WebElement PageBody;

    public BasePage(){
        initElements(WebDriverManager.driver, this);
    }

    public String getCurrentWindow() {
        return currentWindow;
    }

    public void openNewTab(){
        PageBody.sendKeys(Keys.CONTROL + "t");
        /*Actions action = new Actions(WebDriverManager.driver);
        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();*/
    }

    public LoggedInPage switchToLastOpenedTab(){
        for(String winHandle : WebDriverManager.driver.getWindowHandles()){
            WebDriverManager.driver.switchTo().window(winHandle);
        }
        return new LoggedInPage();
    }

    public Header OnHeader(){
        return new Header();
    }
}
