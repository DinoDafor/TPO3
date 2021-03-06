import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;



import static org.junit.Assert.assertTrue;

public class SettingsTest extends MyTest {

    public LoginTest loginTest = new LoginTest();

    @BeforeClass
    public static void setup() {
        //todo naming
        firstSetUp();
        lastSetUp();
    }

    @Test
    public void changeNameTest() {
        driverList.forEach(driver -> {
            //todo придется в фабрике добавлять страницы
            TestFactory.initPages(driver, Pages.SETTINGS);
            loginTest.loginIn(driver);
            driver.get("https://ask.fm/account/settings/profile");
            settingsPage.changeName("Гена Букин");
            settingsPage.clickOnChangeSettingsButton();
            driver.get("https://ask.fm/id136288113");
            assertTrue(profilePage.checkProfileName("Гена Букин"));
        });
    }

    @Test
    public void changeLocationTest() {
        driverList.forEach(driver -> {
            TestFactory.initPages(driver, Pages.SETTINGS);
            loginTest.loginIn(driver);
            driver.get("https://ask.fm/account/settings/profile");
            settingsPage.changeLocation("Kiev");
            settingsPage.clickOnChangeSettingsButton();
            driver.get("https://ask.fm/id136288113");
            assertTrue(profilePage.checkCity("Kiev"));
        });
    }

    @Test
    public void changeAboutMeTest() {
        driverList.forEach(driver -> {
            TestFactory.initPages(driver, Pages.SETTINGS);
            loginTest.loginIn(driver);
            driver.get("https://ask.fm/account/settings/profile");
            settingsPage.changeAboutMe("Working in shoe store");
            settingsPage.clickOnChangeSettingsButton();
            driver.get("https://ask.fm/id136288113");
            assertTrue(profilePage.checkAboutMe("Working in shoe store"));
        });
    }

    @Test
    public void changeSiteTest() {
        driverList.forEach(driver -> {
            TestFactory.initPages(driver, Pages.SETTINGS);
            loginTest.loginIn(driver);
            driver.get("https://ask.fm/account/settings/profile");
            settingsPage.changeSite("google.com");
            settingsPage.clickOnChangeSettingsButton();
            driver.get("https://ask.fm/id136288113");
            assertTrue(profilePage.checkSite("google.com"));
        });
    }

    @Test //todo Здесь найден баг, но не мой
    public void changeInterestsTest() {
        driverList.forEach(driver -> {
            TestFactory.initPages(driver, Pages.SETTINGS);
            loginTest.loginIn(driver);
            driver.get("https://ask.fm/account/settings/profile");
            settingsPage.changeInterests("LoveShoes ");
            settingsPage.clickOnChangeSettingsButton();
            driver.get("https://ask.fm/id136288113");
            assertTrue(profilePage.checkHashTags("#loveshoes"));
        });
    }


    @AfterClass
    public static void tearsDown() {
        driverList.forEach(WebDriver::quit);
    }


}
