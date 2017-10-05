package pages;

import globals.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverManager;


import java.io.File;

public class NewAppPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement pageName;

    @FindBy(name = "title")
    private WebElement titleField;

    @FindBy(name = "description")
    private WebElement descriptionTextArea;

    @FindBy(name = "category")
    private WebElement categorySelect;
    private Select categoryDropdown = new Select(categorySelect);

    @FindBy(xpath = "//tr[4]/td[2]/input")
    private WebElement appImageBrowseButton;

    @FindBy(xpath = "//tr[5]/td[2]/input")
    private WebElement appIconBrowseButton;

    @FindBy(xpath = "//input[@value='Create']")
    private WebElement createButton;


    public String getPageName(){
        return pageName.getText();
    }

    public MyAppsPage addNewAppWithoutImgAndIcon(Application app){
        titleField.sendKeys(app.getAppName());
        descriptionTextArea.sendKeys(app.getAppDescription());
        categoryDropdown.selectByVisibleText(app.getAppCatgory());
        createButton.click();
        return new MyAppsPage();
    }

    public MyAppsPage addNewAppWithImageAndIcon(Application app, String pathToImage, String pathToIcon){
        //File image = new File(GetPathToResorce.getPath(pathToImage));
        //File icon = new File(GetPathToResorce.getPath(pathToIcon));
        //File image = new File(String.valueOf(this.getClass().getClassLoader().getResource(pathToImage)));
        //File icon = new File(String.valueOf(this.getClass().getClassLoader().getResource(pathToIcon)));
        File image = new File(getPath(pathToImage));
        File icon = new File(getPath(pathToIcon));
        titleField.sendKeys(app.getAppName());
        descriptionTextArea.sendKeys(app.getAppDescription());
        categoryDropdown.selectByVisibleText(app.getAppCatgory());
        appImageBrowseButton.sendKeys(image.getAbsolutePath());
        appIconBrowseButton.sendKeys(icon.getAbsolutePath());
        createButton.click();
        return new MyAppsPage();
    }

    private String getPath(String fileName){
        return System.getProperty("user.dir") + "\\src\\test\\resources\\img\\" + fileName;
    }




}
