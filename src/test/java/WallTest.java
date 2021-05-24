import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WallTest extends MyTest {


    @BeforeClass
    public static void setup() {
        firstSetUp();
        lastSetUp();
    }

    @Test
    public void makeQuestionTest() {
        driverList.forEach(driver -> {
        TestFactory.initPages(driver, Pages.WALL);
        driver.get("https://ask.fm/account/wall");
        wallPage.inputQuestion("Тест функционала");
        wallPage.clickFirstButton();
        wallPage.clickOnFriend();
        wallPage.clickSecondButton();
        driver.get("https://ask.fm/account/notifications");
        notificationPage.checkNewQuestion("Вы получили анонимный вопрос \"Тест функционала\"");
        });


    }


    @Test
    public void deleteQuestionTest(){
        driverList.forEach(driver -> {
        TestFactory.initPages(driver, Pages.WALL);
        driver.get("https://ask.fm/account/wall");
        wallPage.clickOnQuestionIcon();
        wallPage.clickOnMoreForQuestion();
        int countOfQuestions = Integer.parseInt(wallPage.getCountOfQuestions().getText());
        wallPage.clickOnDeleteQuestionButton();
        assertEquals(countOfQuestions - 1, Integer.parseInt(wallPage.getCountOfQuestions().getText()));
        });
    }
    //todo Когда удалены все вопросы, кроме вопросов дня, то нет кнопки "удалить все вопросы"
    @Test
    public void deleteAllQuestionsTest() {
        driverList.forEach(driver -> {
        TestFactory.initPages(driver, Pages.WALL);
        driver.get("https://ask.fm/account/wall");
        wallPage.clickOnQuestionIcon();
        wallPage.clickOnDeleteAllQuestionsButton();
        wallPage.acceptAlert();
        assertTrue(wallPage.checkAmountOfQuestions());
        });

    }

    @Test
    public void answerOnQuestionTest() {
        driverList.forEach(driver -> {
        TestFactory.initPages(driver, Pages.WALL);
        driver.get("https://ask.fm/account/wall");
        wallPage.clickOnQuestionIcon();
        wallPage.clickOnButtonAnswer();
        wallPage.inputAnswer("Test");
        wallPage.clickOnSendButton();
        //todo Не помню уже для чего эта строка, т.к. Alert не возникает позже, пусть здесь и будет
       // wallPage.clickOnCloseAlertAfterAnswer();
        driver.get("https://ask.fm/account/wall");
        assertTrue(wallPage.checkAnswerText("Test"));
        });

    }

    @AfterClass
    public static void tearsDown(){
        driverList.forEach(driver -> {
        driver.quit();
        });

    }




}
