import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SettingsTest {
    public static SettingsPage settingsPage;
    public static WebDriver driver;
    public WebDriverWait wait;
    public static ProfilePage profilePage;

    @BeforeClass
    public static void setup() {
        if (ConfProperties.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Local\\Google\\Chrome\\User Data\\TPOProfile");

            driver = new ChromeDriver(options);
            settingsPage = new SettingsPage(driver);
            profilePage = new ProfilePage(driver);

            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            driver.get("https://ask.fm/account/settings/profile");
        } else if (ConfProperties.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));


            FirefoxOptions options = new FirefoxOptions();

            options.addArguments("-profile");
            options.addArguments("C:\\Users\\dinod\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\t0ugfd74.default");


            driver = new FirefoxDriver(options);

            settingsPage = new SettingsPage(driver);
            profilePage = new ProfilePage(driver);

            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            driver.get("https://ask.fm/account/settings/profile");

        } else {
            //todo ошибка
        }

    }

    @Test
    public void changeNameTest() {
        settingsPage.changeName("Гена Букин");
        settingsPage.clickOnChangeSettingsButton();
        driver.get("https://ask.fm/id136288113");
        assertTrue(profilePage.checkProfileName("Гена Букин"));

    }

    @Test
    public void changeLocationTest() {
        settingsPage.changeLocation("Kiev");
        settingsPage.clickOnChangeSettingsButton();
        driver.get("https://ask.fm/id136288113");
        assertTrue(profilePage.checkCity("Kiev"));

    }

    @Test
    public  void changeAboutMeTest() {
        settingsPage.changeAboutMe("Working in shoe store");
        settingsPage.clickOnChangeSettingsButton();
        driver.get("https://ask.fm/id136288113");
        assertTrue(profilePage.checkAboutMe("Working in shoe store"));

    }

    @Test
    public void changeSiteTest() {
        settingsPage.changeSite("google.com");
        settingsPage.clickOnChangeSettingsButton();
        driver.get("https://ask.fm/id136288113");
        assertTrue(profilePage.checkSite("google.com"));

    }

    @Test //todo Здесь найден баг, но не мой
    public void changeInterestsTest() {
        settingsPage.changeInterests("LoveShoes ");
        settingsPage.clickOnChangeSettingsButton();
        driver.get("https://ask.fm/id136288113");
        assertTrue(profilePage.checkHashTags("#loveshoes"));

    }


    @AfterClass
    public static void tearsDown(){
        driver.quit();
    }


}
