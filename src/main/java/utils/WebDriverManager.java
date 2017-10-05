package utils;

import com.opencsv.CSVReader;
import globals.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.UserAndPassword;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public static WebDriver driver;

    public static void OpenBrowser(){

        String browser = PropertiesReader.getPropertiesFromFile("selenium.properties").getProperty("browser");

        if (browser.equals("Chrome")){
            String chromeDriverPath = WebDriverManager.class.getClassLoader().getResource("chromedriver.exe").getPath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        else if (browser.equals("Firefox"))
            driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void CloseBrowser(){
        driver.quit();
    }

    public static String getTextOfAlert(){
       return driver.switchTo().alert().getText();
    }

    public static boolean isBasicAuthenticationEnabled(){
        if (PropertiesReader.getPropertiesFromFile("selenium.properties").getProperty("basicAuthentication").equals("true"))
            return true;
        else
            return false;
    }

    public static void authenticateBasic(User user){
        WebDriverManager.driver.get("http://" + user.getUsername() + ":" + user.getPassword() + "@localhost:8080");
        SiteNavigator.openLoginPage();

    }

}
