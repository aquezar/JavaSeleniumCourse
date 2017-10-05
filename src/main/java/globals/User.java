package globals;

public class User {
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String role;

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getRole() {
        return role;
    }

    public void setRoleUser() {
        this.role = "USER";
    }

    public void setRoleDeveloper(){
        this.role = "DEVELOPER";
    }

    public User(){}

    public User(String username, String password, String fName, String lName, String role){
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.role = role.toUpperCase();
    }

    public User setDefaultAdminCredentials(){
        User admin = new User();
        admin.username = "admin";
        admin.password = "admin";
        admin.fName = "Ivan";
        admin.lName = "Petrov";
        return admin;
    }

    public static User getDafaultDeveloperAccount(){
        return new User("developer", "devPass", "Taras", "Bogdanov", "DEVELOPER");
    }


}
