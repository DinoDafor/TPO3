import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTest extends MyTest {

    @BeforeClass
    public static void setup() {
        //todo naming, переделать под 1 функцию
        firstSetUp();
        lastSetUp();

    }
    public void loginIn(WebDriver driver){
        TestFactory.initPages(driver, Pages.LOGIN);
        driver.get(ConfProperties.getProperty("loginpage"));
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
    @Test
    public void loginTest() {
        driverList.forEach(driver -> {
            loginIn(driver);
        });


    }

    @Test //todo тут тоже баг сайта кстати
    public void registrationTest() {
        driverList.forEach(driver -> {
            TestFactory.initPages(driver, Pages.LOGIN);
            driver.get("https://ask.fm/");
            loginPage.clickOnRegisterButton();
            loginPage.inputRegistrationEmail("doddoser@mail.ru");
            loginPage.selectBirthday();
            loginPage.clickOnRegisterSecondButton();
            loginPage.inputNameForRegistration("doddoser69");
            loginPage.clickOnRegisterSecondButton();
            driver.get("https://ask.fm/doddoser69");
            assertTrue(profilePage.checkProfileID("@doddoser69"));
        });

    }

    @AfterClass
    public static void tearsDown() {
        driverList.forEach(WebDriver::quit);
    }
}