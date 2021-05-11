import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WallTest {

    public static WallPage wallPage;
    public static WebDriver driver;
    public static NotificationPage notificationPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\dinod\\AppData\\Local\\Google\\Chrome\\User Data\\TPOProfile");

        driver = new ChromeDriver(options);
        wallPage = new WallPage(driver);
        notificationPage = new NotificationPage(driver);
        driver.manage().window().maximize();



        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("https://ask.fm/account/wall");

    }

    @Test
    public void makeQuestionTest() {
        wallPage.inputQuestion("Тест функционала");
        wallPage.clickFirstButton();
        wallPage.clickOnFriend();
        wallPage.clickSecondButton();
        driver.get("https://ask.fm/account/notifications");
        notificationPage.checkNewQuestion("Вы получили анонимный вопрос \"Тест функционала\"");
       


    }


    @Test
    public void deleteQuestionTest(){
        wallPage.clickOnQuestionIcon();
        wallPage.clickOnMoreForQuestion();
        int countOfQuestions = Integer.parseInt(wallPage.getCountOfQuestions().getText());
        wallPage.clickOnDeleteQuestionButton();
        assertEquals(countOfQuestions - 1, Integer.parseInt(wallPage.getCountOfQuestions().getText()));

    }
    //todo Когда удалены все вопросы, кроме вопросов дня, то нет кнопки "удалить все вопросы"
    @Test
    public void deleteAllQuestionsTest() {

        wallPage.clickOnQuestionIcon();
        wallPage.clickOnDeleteAllQuestionsButton();
        wallPage.acceptAlert();
        assertTrue(wallPage.checkAmountOfQuestions());


    }

    @Test
    public void answerOnQuestionTest() {
        wallPage.clickOnQuestionIcon();
        wallPage.clickOnButtonAnswer();
        wallPage.inputAnswer("Test");
        wallPage.clickOnSendButton();
        //todo Не помню уже для чего эта строка, т.к. Alert не возникает позже, пусть здесь и будет
       // wallPage.clickOnCloseAlertAfterAnswer();
        driver.get("https://ask.fm/account/wall");
        assertTrue(wallPage.checkAnswerText("Test"));


    }

//    @Test
//    public void exitTest(){
//
//    wallPage.clickOnSettingsIcon();
//    wallPage.clickOnExit();
//    }
    @AfterClass
    public static void tearsDown(){
        driver.quit();
    }




}
