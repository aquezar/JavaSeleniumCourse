import globals.User;
import org.testng.annotations.Test;
import pages.LoggedInPage;
import utils.SiteNavigator;

public class LogoutTests extends BaseTest {

    @Test(enabled = false)
    public void loginSwitchTabAndLogOut(){
        User admin = new User().setDefaultAdminCredentials();
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(admin);
        loggedInPage.getCurrentWindow();
        loggedInPage.openNewTab();
        loggedInPage.switchToLastOpenedTab();

    }


}
