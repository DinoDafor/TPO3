import org.openqa.selenium.WebDriver;

public class TestFactory {
    public static void initPages(WebDriver driver, Pages pages) {
        switch (pages) {
            case LOGIN:
                MyTest.loginPage = new LoginPage(driver);
                MyTest.wallPage = new WallPage(driver);
                MyTest.profilePage = new ProfilePage(driver);
                break;
            case WALL:
                MyTest.wallPage = new WallPage(driver);
                MyTest.notificationPage = new NotificationPage(driver);
                break;
            case SETTINGS:
                MyTest.profilePage = new ProfilePage(driver);
                MyTest.settingsPage = new SettingsPage(driver);
                break;
        }
    }
}
