package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppEditPage extends BasePage {

    @FindBy(name = "description")
    private WebElement descriptionTextArea;

    @FindBy(name = "category")
    private WebElement categorySelect;
    private Select categoryDropdown = new Select(categorySelect);

    @FindBy(name = "image")
    private WebElement browseImageButton;

    @FindBy(name = "icon")
    private WebElement browseIconButton;

    @FindBy(xpath = "//input[@value='Update']")
    private WebElement updateButton;

    public String getAppDescription(){
        return descriptionTextArea.getText();
    }

    public void editAppDescription(String newDescription){
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(newDescription);
    }

    public void clickUpdateButton(){
        updateButton.click();
    }

}
