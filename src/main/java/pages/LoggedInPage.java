package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class LoggedInPage extends BasePage {
    @FindBy(className = "app")
    private List<WebElement> appsList;

    @FindBy(xpath = "//div[@class='app']/div[@class='name']")
    private List<WebElement> appsListName;

    @FindBy(xpath = "//div[@class='app']/div[@class='description']")
    private List<WebElement> appsListDescription;

    @FindBy(xpath = "//div[@class='app']/div[@class='downloads']")
    private List<WebElement> appsListDownloads;

    @FindBy(linkText = "Details")
    private List<WebElement> appsListDetailsLink;



    public List<WebElement> getAppsList() {
        return appsList;
    }
    public List<WebElement> getAppsListName() {
        return appsListName;
    }
    public List<WebElement> getAppsListDescription() {
        return appsListDescription;
    }
    public List<WebElement> getAppsListDownloads() {
        return appsListDownloads;
    }
    public List<WebElement> getAppsListDetailsLink() {
        return appsListDetailsLink;
    }


}
