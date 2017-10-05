package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppDetailsPage extends BasePage {

    @FindBy(className = "name")
    private WebElement appName;

    @FindBy(xpath = "//*[@class='application']/div[2]")
    private WebElement appDescription;

    @FindBy(xpath = "//*[@class='application']/div[3]")
    private WebElement appCategory;

    @FindBy(xpath = "//*[@class='application']/div[4]")
    private WebElement appAuthor;

    @FindBy(className = "downloads")
    private WebElement appDownloads;

    @FindBy(linkText = "Download")
    private WebElement appDownloadButton;

    @FindBy(linkText = "Delete")
    private WebElement appDeleteButton;

    @FindBy(linkText = "Edit")
    private WebElement appEditButton;


    public AppEditPage clickEditButton(){
        appEditButton.click();
        return new AppEditPage();
    }

    public AppDownloadPage clickDownloadButton(){
        appDownloadButton.click();
        return new AppDownloadPage();
    }




}
