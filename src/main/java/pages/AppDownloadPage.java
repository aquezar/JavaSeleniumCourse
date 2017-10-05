package pages;

import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AppDownloadPage extends BasePage {

    @FindBy(xpath = ".//*[@class='data']")
    private WebElement rawJSON;

    public JSONObject getJSON(){
        String json = new JSONObject(WebDriverManager.driver.getCurrentUrl()).toString();

        JSONObject appDownload = new JSONObject(WebDriverManager.driver.getCurrentUrl());

        return appDownload;
    }

    public JSONObject json() throws MalformedURLException {

        URL url = new URL(WebDriverManager.driver.getCurrentUrl());

        Scanner scan = null;
        try {
            scan = new Scanner(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        JSONObject obj = new JSONObject(url);

        return obj;
    }
}
