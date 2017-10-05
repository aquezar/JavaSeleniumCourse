package utils;

import pages.LoginPage;

public class SiteNavigator {

    public static LoginPage openLoginPage(){
        WebDriverManager.driver.get("http://localhost:8080/");
        return new LoginPage();
    }

}
