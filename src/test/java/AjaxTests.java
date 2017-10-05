import globals.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AjaxCalcPage;
import utils.SiteNavigator;

public class AjaxTests extends BaseTest {

    private String x = "3";
    private String y = "76";
    private String invalidY = "string";

    //Enter two valid numbers, click ‘Sum’, wait for result and check that result is correct.
    @Test
    public void checkSumOfValidValues(){
        User admin = new User().setDefaultAdminCredentials();
        AjaxCalcPage ajaxCalcPage = SiteNavigator.openLoginPage().LogIn(admin).OnHeader().clickAjaxTestPageLink();
        ajaxCalcPage.setXField(x);
        ajaxCalcPage.setYField(y);
        ajaxCalcPage.clickSumButton();
        Assert.assertTrue(ajaxCalcPage.isResultsCorrect(x, y));
    }

    //Enter two valid numbers, click ‘Sum’, wait for result and check that result is correct.
    @Test
    public void checkSumOfInvalidValues(){
        User admin = new User().setDefaultAdminCredentials();
        AjaxCalcPage ajaxCalcPage = SiteNavigator.openLoginPage().LogIn(admin).OnHeader().clickAjaxTestPageLink();
        ajaxCalcPage.setXField(x);
        ajaxCalcPage.setYField(invalidY);
        ajaxCalcPage.clickSumButton();
        Assert.assertTrue(ajaxCalcPage.isResultsCorrect(x, invalidY));
    }
}
