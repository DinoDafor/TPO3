import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public NotificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/div[1]/div/div[1]/a")
    private WebElement notificationQuestion;

    public boolean checkNewQuestion(String question){
        String st = notificationQuestion.getText();
        return notificationQuestion.getText().equals(question);
    }

}
