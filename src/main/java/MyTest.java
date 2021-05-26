import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyTest {
    public static   LoginPage loginPage;
    public  static WallPage wallPage;
    public  static ProfilePage profilePage;
    public  static NotificationPage notificationPage;
    public static SettingsPage settingsPage;
    public static List<WebDriver> driverList;

    //public static WebDriver driver;
    public   WebDriverWait wait;

    public static void firstSetUp(){
        driverList = new ArrayList<>();
        if (ConfProperties.getProperty("isChrome").equals("yes")  && !ConfProperties.getProperty("isFirefox").equals("yes")) {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
           // ChromeOptions options = new ChromeOptions();
            //options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Local\\Google\\Chrome\\User Data\\TPOProfile");
            //driverList.add(new ChromeDriver(options));
            driverList.add(new ChromeDriver());
        } else if (ConfProperties.getProperty("isFirefox").equals("yes") && !ConfProperties.getProperty("isChrome").equals("yes")){
            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));
            driverList.add(new FirefoxDriver());
        } else if (ConfProperties.getProperty("isChrome").equals("yes") && ConfProperties.getProperty("isFirefox").equals("yes")){
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            //ChromeOptions options = new ChromeOptions();
           // options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Local\\Google\\Chrome\\User Data\\TPOProfile");

           //driverList.add(new ChromeDriver(options));
            driverList.add(new ChromeDriver());

            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));
            driverList.add(new FirefoxDriver());
        } else {
            //todo кидать ошибку, что не надо запускать никакой драйвер
        }

    }
    public static void lastSetUp(){
        driverList.forEach(driver -> {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        });

    }


}
