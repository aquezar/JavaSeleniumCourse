import globals.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.JSTestPage;
import utils.SiteNavigator;
import utils.WebDriverManager;

public class JSTests extends BaseTest {

    @Test
    public void findDivPositionAndCheckCoordinates(){
        User admin = new User().setDefaultAdminCredentials();
        JSTestPage jsTestPage = SiteNavigator.openLoginPage().LogIn(admin).OnHeader().clickJSTestPageLink();
        jsTestPage.setTopFieldValue();
        jsTestPage.setLeftFieldValue();
        jsTestPage.clickProceedButton();
        String a = WebDriverManager.getTextOfAlert();
        Assert.assertTrue(WebDriverManager.getTextOfAlert().equals("Whoo Hoooo! Correct!"));

    }
}
