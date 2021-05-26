import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallPage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Позволяет менять драйвера браузера при создании
    public WallPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"question_question_text\"]")
    private WebElement questionField;

    public void inputQuestion(String question) {
        questionField.sendKeys(question);
    }

    @FindBy(xpath = "//*[@id=\"wallIndexForm\"]/div[2]/button")
    private WebElement firstButton;

    public void clickFirstButton() {
        firstButton.click();
    }

    @FindBy(xpath = "//*[@id=\"MassAskSearch\"]/div/div/a")
    private WebElement friend;

    public void clickOnFriend() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassAskSearch\"]/div/div/a")));
        friend.click();
    }

    @FindBy(xpath = "//*[@id=\"massQuestionsNewForm\"]/div[6]/button")
    private WebElement secondButton;

    public void clickSecondButton() {
        secondButton.click();
    }

    @FindBy(xpath = "//*[@id=\"topMenu\"]/div[1]/section/nav/a[2]")
    private WebElement questionIcon;

    public void clickOnQuestionIcon() {
        questionIcon.click();
    }


    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/div[2]/div/article[1]/div[2]/div/div[2]/a")
    private WebElement iconMoreForQuestion;

    public void clickOnMoreForQuestion() {
        wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentArea\"]/div/div/section/div[2]/div/article[1]/div[2]/div/div[2]/a")));
        iconMoreForQuestion.click();
    }


    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/div[2]/div/article[1]/div[2]/div/div[2]/nav/a[1]")
    private WebElement deleteQuestionButton;

    public void clickOnDeleteQuestionButton() {
        deleteQuestionButton.click();
    }


    @FindBy(xpath = "//*[@id=\"questions-delete\"]")
    private WebElement deleteAllQuestionsButton;

    public void clickOnDeleteAllQuestionsButton() {
        //todo возможно этот объект стоит вынести
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"questions-delete\"]")));
        deleteAllQuestionsButton.click();
    }

    public void acceptAlert() {
        wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/div[2]/div/article[1]/div[2]/a")
    private WebElement buttonForAnswer;



    public void clickOnButtonAnswer() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentArea\"]/div/div/section/div[2]/div/article[1]/div[2]/a")));
        buttonForAnswer.click();
    }

    @FindBy(xpath = "//*[@id=\"question_answer_text\"]")
    private WebElement fieldForAnswer;

    public void inputAnswer(String answer) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_answer_text\"]")));
        fieldForAnswer.sendKeys(answer);
    }

    @FindBy(xpath = "//*[@id=\"answersNewForm\"]/div[2]/div/button")
    private WebElement buttonForSendAnswer;

    public void clickOnSendButton() {
        buttonForSendAnswer.click();
    }

    @FindBy(xpath = "/html/body/div[4]/div/section/a")
    private WebElement closeAlertAfterAnswer;

    public void clickOnCloseAlertAfterAnswer() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/section/a")));
        closeAlertAfterAnswer.click();
    }

    @FindBy(xpath = "//*[@id=\"topMenu\"]/div[1]/section/nav/a[6]")
    private WebElement settingsIcon;

    public void clickOnSettingsIcon() {
        settingsIcon.click();
    }

    @FindBy(xpath = "//*[@id=\"settings-popover-menu\"]/a[2]")

    private WebElement exit;

    public void clickOnExit() {

        exit.click();
    }


    //*[@id="contentArea"]/div/div/section/header/h1/span
    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/header/h1")
    private WebElement countOfQuestions;

    public boolean checkAmountOfQuestions() {
        return countOfQuestions.getText().trim().equals("Вопросы");
//        return (countOfQuestions.getText().equals("0")
//                || countOfQuestions.getText().equals("1"));
    }

    public WebElement getCountOfQuestions() {
        return countOfQuestions;
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section[2]/div[2]/div/article/div[2]")
    private WebElement wallAnswerText;

    public boolean checkAnswerText(String text) {
        return wallAnswerText.getText().equals(text);
    }
}
