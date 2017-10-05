package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverManager;


public class AjaxCalcPage extends BasePage {

    @FindBy(id = "x")
    private WebElement xField;

    @FindBy(id = "y")
    private WebElement yField;

    @FindBy(id = "result")
    private WebElement calcResult;

    @FindBy(id = "calc")
    private WebElement sumButton;

    @FindBy(id = "clear")
    private WebElement clearButton;

    public String getX(){
        return xField.getText();
    }
    public String getY(){
        return yField.getText();
    }

    public void setXField(String x){
        xField.sendKeys(x);
    }

    public void setYField(String y){
        yField.sendKeys(y);
    }

    public void clickClearButton(){
        clearButton.click();
    }

    public void clickSumButton(){
        sumButton.click();
    }

    private String getCalcResults(){
        WebDriverWait wait = new WebDriverWait(WebDriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(calcResult));
        return calcResult.getText();
    }

    public boolean isResultsCorrect(String x, String y) {
        String i = getCalcResults();
        if (getCalcResults().equals("Result is: Incorrect data"))
            return true;
        else {
            double a = Double.parseDouble(x);
            double b = Double.parseDouble(y);
            double calcResult = Double.parseDouble(getCalcResults().substring(getCalcResults().lastIndexOf(" ")));
            double expectedResult = a + b;
            if (calcResult == expectedResult)
                return true;
            else
                return false;
        }
    }

}
