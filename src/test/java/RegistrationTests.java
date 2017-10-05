import dataProviders.DataProviders;
import globals.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.MyAppsPage;
import pages.NewAppPage;
import utils.SiteNavigator;


public class RegistrationTests extends BaseTest {

    //Register new user and verify that it is logged in
    @Test
    public void registerUserAndLogin(){
        User user = new User("user", "password", "Igor", "Stepanov", "developer");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(user);
        Assert.assertEquals(loggedInPage.OnHeader().getLoggedInUserNameText(), "Welcome " + user.getfName() + " " + user.getlName());
    }

    //Register new user, logout and verify that user can login
    @Test
    public void registerUserLogoutAndLogin(){
        User user = new User("newuser", "password", "Sergey", "Ivanov", "user");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(user);
        LoginPage loginPage = loggedInPage.OnHeader().clickLogoutLink();
        LoggedInPage newLoggedInPage = loginPage.LogIn(user);
        Assert.assertEquals(newLoggedInPage.OnHeader().getLoggedInUserNameText(), "Welcome " + user.getfName() + " " + user.getlName());
    }

    //Register as developer, verify that user can open page to upload application.
    @Test
    public void registerDeveloperAndCheckUploadAppIsAvailable(){
        User developer = new User("developer", "devPass", "Taras", "Bogdanov", "developer");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(developer);
        MyAppsPage myAppsPage = loggedInPage.OnHeader().clickMyApplicationsLink();
        NewAppPage newAppPage = myAppsPage.clickAddApplicationLink();
        Assert.assertEquals(newAppPage.getPageName(), "New application");
    }

    //Register as regular user, verify that user can see applications but cannot upload them
    @Test
    public void registerUserAndCheckAppListAvailability(){
        User user = new User("testUser", "usrPass", "Irina", "Vasilieva", "user");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(user);
        Assert.assertTrue(loggedInPage.getAppsList().size() > 0);
        Assert.assertTrue(!loggedInPage.OnHeader().isMyApplicationsLinkPresent());
    }

    @Test(dataProvider = "users", dataProviderClass = DataProviders.class)
    public void regUsersFromCsv(String username, String password, String fName, String lName, String role){
        User user = new User(username, password, fName, lName, role);
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().openRegisterPage().registerNewUser(user);
        Assert.assertEquals(loggedInPage.OnHeader().getLoggedInUserNameText(), "Welcome " + user.getfName() + " " + user.getlName());
        System.out.printf("New %s registered! Welcome %s %s! Your username is: %s and password is: %s", user.getRole(), user.getfName(), user.getlName(), user.getUsername(), user.getPassword());
    }



}
