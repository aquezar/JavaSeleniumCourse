import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListeners;
import utils.WebDriverManager;

@Listeners(TestListeners.class)
public class BaseTest {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.OpenBrowser();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverManager.CloseBrowser();
    }


}
