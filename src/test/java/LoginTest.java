import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static WallPage wallPage;
    public static WebDriver driver;
    public static ProfilePage profilePage;

    public WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        if (ConfProperties.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();

            options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Local\\Google\\Chrome\\User Data\\TPOProfile");

            driver = new ChromeDriver(options);
            loginPage = new LoginPage(driver);
            wallPage = new WallPage(driver);
            profilePage = new ProfilePage(driver);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfProperties.getProperty("loginpage"));
        }
        else if (ConfProperties.getProperty("browser").equals("firefox")){
            System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));
            driver = new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\TPOProfile");
            driver = new FirefoxDriver(options);
            loginPage = new LoginPage(driver);
            wallPage = new WallPage(driver);
            profilePage = new ProfilePage(driver);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfProperties.getProperty("loginpage"));
        }
        else {
            //todo ошибка
        }
    }

    @Test
    public void loginTest() {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        assertTrue(loginPage.checkLoginAndPassFields(ConfProperties.getProperty("login"), ConfProperties.getProperty("password")));
        loginPage.clickLoginBtn2();
        wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topMenu\"]/div[1]/section/nav/a[3]")));
        driver.get("https://ask.fm/id136288113");

        assertTrue(profilePage.checkProfileID("@id136288113"));

    }

    @Test //todo тут тоже баг сайта кстати
    public void registrationTest() {
        loginPage.clickOnRegisterButton();
        loginPage.inputRegistrationEmail("doddoser@mail.ru");
        loginPage.selectBirthday();
        loginPage.clickOnRegisterSecondButton();
        loginPage.inputNameForRegistration("doddoser69");

        loginPage.clickOnRegisterSecondButton();
        driver.get("https://ask.fm/doddoser69");

        assertTrue(profilePage.checkProfileID("@doddoser69"));

    }
    @AfterClass
    public static void tearsDown(){
        driver.quit();
    }
}