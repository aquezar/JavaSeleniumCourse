import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoggedInPage;
import pages.LoginPage;
import utils.SiteNavigator;
import globals.User;

public class LoginTests extends BaseTest{

    private String expectedLoginErrorMessageText = "You have entered an invalid username or password!";

    //Login as valid user
    @Test
    public void loginWithValidCredentials(){
        User user = new User().setDefaultAdminCredentials();
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(user);
        Assert.assertEquals(loggedInPage.OnHeader().getLoggedInUserNameText(), "Welcome " + user.getfName() + " " + user.getlName());
    }

    //Login as valid user with incorrect password
    @Test
    public void loginWithInvalidPassword(){
        User user = new User().setDefaultAdminCredentials();
        user.setPassword("invalidpassword");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(user);
        Assert.assertEquals(new LoginPage().getErrorLoginMessageText(), expectedLoginErrorMessageText);
    }

}
