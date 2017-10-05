import globals.Application;
import globals.User;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.GetJsonFromUrl;
import utils.SiteNavigator;
import utils.WebDriverManager;

import java.net.MalformedURLException;


public class ApplicationsTests extends BaseTest {

    //Create new application without images. Verify it is displayed correctly and can be downloaded.
    @Test
    public void addNewAppVerifyIsDisplayedAndDownloadable(){
        User developer = User.getDafaultDeveloperAccount();
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(developer);
        NewAppPage newAppPage = loggedInPage.OnHeader().clickMyApplicationsLink().clickAddApplicationLink();
        Application application = Application.getDefaultAppForDefaultDeveloper();
        MyAppsPage myAppsPage = newAppPage.addNewAppWithoutImgAndIcon(application);
        Assert.assertTrue(myAppsPage.isAppDisplayed(application));
    }

    //Edit application without images and verify that changes applied.
    @Test
    public void editAppVerifyIsChangeApplied(){
        String description = "Description that will change original one for app";
        User developer = User.getDafaultDeveloperAccount();
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(developer);
        Application application = Application.getDefaultAppForDefaultDeveloper();
        AppDetailsPage appDetailsPage = loggedInPage.OnHeader().clickMyApplicationsLink().clickDetailsForSpecificApp(application);
        AppEditPage appEditPage = appDetailsPage.clickEditButton();
        appEditPage.editAppDescription(description);
        appEditPage.clickUpdateButton();
        MyAppsPage myAppsPage = appEditPage.OnHeader().clickMyApplicationsLink();
        Assert.assertTrue(myAppsPage.getSpecificApp(application).get(1).getText().equals(description));
    }

    //Create new application with image and icon.
    @Test
    public void addNewAppWithImageAndIcon(){
        User developer = User.getDafaultDeveloperAccount();
        Application application = new Application("Application with Image", "Description for this Application with image. It also contains icon", "Maps", developer.getUsername());
        MyAppsPage myAppsPage = SiteNavigator.openLoginPage().LogIn(developer).OnHeader().clickMyApplicationsLink().clickAddApplicationLink().addNewAppWithImageAndIcon(application, "appImage.jpg", "appIcon.jpg");
        //TODO assert results
    }

    @Test(enabled = false)
    public void getJSONString() throws MalformedURLException {
        User admin = new User().setDefaultAdminCredentials();
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(admin);
        Application application = new Application("Application Information 1", "Description for this Application with image. It also contains icon", "Maps", "admin");
        AppDownloadPage appDownloadPage = loggedInPage.OnHeader().clickMyApplicationsLink().clickDetailsForSpecificApp(application).clickDownloadButton();


        String url = WebDriverManager.driver.getCurrentUrl();

        try {

            //String a = GetJsonFromUrl.readUrl(url);
            //JSONObject obj = new JSONObject(GetJsonFromUrl.readUrl(url));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Application application = new Application("Application Information 0", "Just a sample description for this application [Application Information 0]", "Information", "admin");
        //JSONObject app = loggedInPage.clickDetailsForSpecificApp(application).clickDownloadButton().getJSON();

    }






}
