import globals.Application;
import globals.User;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pages.LoggedInPage;
import utils.GetJsonFromUrl;
import utils.SiteNavigator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class test extends BaseTest {

    @Test
    public void getJSON() throws IOException {
        String url = "http://localhost:8080/app?title=";
        String body = "Application%20Information%200";
        User admin = new User().setDefaultAdminCredentials();
        Application application = new Application("Application with Image", "Description for this Application with image. It also contains icon", "Maps", "admin");
        LoggedInPage loggedInPage = SiteNavigator.openLoginPage().LogIn(admin);
        GetJsonFromUrl request = new GetJsonFromUrl();
        request.http(url, body, admin.getUsername(), admin.getPassword());

    }




}
