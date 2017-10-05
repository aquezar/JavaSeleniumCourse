package globals;

public class Application {

    private String appName;
    private String appDescription;
    private String appCatgory;
    private String appAuthor;
    private int appDownloads;

    public String getAppName() {
        return appName;
    }
    public String getAppDescription() {
        return appDescription;
    }
    public String getAppCatgory() {
        return appCatgory;
    }
    public String getAppAuthor() {
        return appAuthor;
    }
    public int getAppDownloads() {
        return appDownloads;
    }

    public Application(String appName, String appDescription, String appCatgory, String appAuthor){
        this.appName = appName;
        this.appDescription = appDescription;
        this.appCatgory = appCatgory;
        this.appAuthor = appAuthor;
        this.appDownloads = 0;

    }

    public static Application getDefaultAppForDefaultDeveloper(){
        return new Application("Default application", "Description of Default application", "Information", User.getDafaultDeveloperAccount().getUsername());
    }
}
