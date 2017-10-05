package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSTestPage extends BasePage {

    @FindBy(className = "flash")
    private WebElement findMeDiv;

    @FindBy(id = "top")
    private WebElement topField;

    @FindBy(id = "left")
    private WebElement leftField;

    @FindBy(id = "process")
    private WebElement processButton;

    private Point point = null;

    private String locateXCoord(){
        point = findMeDiv.getLocation();
        Integer y = point.getY();
        return y.toString();
    }

    private String locateYCoord(){
        point = findMeDiv.getLocation();
        Integer x = point.getX();
        return x.toString();
    }

    public void setTopFieldValue(){
        topField.sendKeys(locateXCoord());
    }

    public void setLeftFieldValue(){
        leftField.sendKeys(locateYCoord());
    }

    public void clickProceedButton(){
        processButton.click();
    }
}
