package pages;

import globals.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyAppsPage extends BasePage {
    @FindBy(linkText = "Click to add new application")
    private WebElement addApplicationLink;

    @FindBy(xpath = "//div[@class='app']/div[@class='name']")
    private List<WebElement> appsListName;

    @FindBy(xpath = "//div[@class='app']/div[@class='description']")
    private List<WebElement> appsListDescription;

    @FindBy(xpath = "//div[@class='app']/div[@class='downloads']")
    private List<WebElement> appsListDownloads;

    @FindBy(linkText = "Details")
    private List<WebElement> appsListDetailsLink;

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

    public NewAppPage clickAddApplicationLink(){
        addApplicationLink.click();
        return new NewAppPage();
    }

    public boolean isAddApplicationLikAvailable(){
        if (addApplicationLink.isDisplayed())
            return true;
        else
            return false;
    }


    //Check that app is in the list
    public boolean isAppDisplayed(Application application){
        boolean isAppDisplayed = false;

        try {
            for (WebElement appName : getAppsListName()){
                String name = appName.getText();
                String nameCheck = application.getAppName();
                if (appName.getText().equals(application.getAppName()))
                    isAppDisplayed = true;

            }
            return isAppDisplayed;
        } catch(NoSuchElementException e){
            return isAppDisplayed;
        }
    }

    //Collecting all WebElements for specific app
    public List<WebElement> getSpecificApp(Application application){
        List<WebElement> app = new ArrayList<WebElement>();
        int appIndexInList;
        try {
            for (WebElement appName : getAppsListName()){
                String name = appName.getText();
                String nameCheck = application.getAppName();
                if (appName.getText().equals(application.getAppName())){
                    appIndexInList = getAppsListName().indexOf(appName);
                    app.add(0, appName);
                    app.add(1, getAppsListDescription().get(appIndexInList));
                    app.add(2, getAppsListDownloads().get(appIndexInList));
                    app.add(3, getAppsListDetailsLink().get(appIndexInList));
                }
            }
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        return app;
    }

    public AppDetailsPage clickDetailsForSpecificApp(Application application){
        getSpecificApp(application).get(3).click();
        return new AppDetailsPage();
    }


}
