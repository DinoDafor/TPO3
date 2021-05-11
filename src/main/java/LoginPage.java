import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"user_name\"]")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/main/div/a[2]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"sessionNewForm\"]/div[5]/input")
    private WebElement loginBtn2;


    @FindBy(xpath = "//*[@id=\"user_password\"]")
    private WebElement passwdField;


    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }


    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickLoginBtn2() {
        loginBtn2.click();
    }


    @FindBy(xpath = "/html/body/main/div/a[1]")
    private WebElement registerFirstButton;


    public void clickOnRegisterButton() {
        registerFirstButton.click();
    }

    @FindBy(xpath = "//*[@id=\"user_email\"]")
    private WebElement registrationEmail;

    public void inputRegistrationEmail(String newEmail) {
        registrationEmail.sendKeys(newEmail);
    }


    @FindBy(xpath = "//*[@id=\"date_day\"]/option[2]")
    private WebElement registrationDay;
    @FindBy(xpath = "//*[@id=\"date_month\"]/option[2]")
    private WebElement registrationMonth;
    @FindBy(xpath = "//*[@id=\"date_year\"]/option[18]")
    private WebElement registrationYear;

    public void selectBirthday() {
        registrationDay.click();
        registrationMonth.click();
        registrationYear.click();
    }

    @FindBy(xpath = "//*[@id=\"signupNewForm\"]/div[4]/input")
    private WebElement registerSecondButton;

    public void clickOnRegisterSecondButton() {
        registerSecondButton.click();
    }

    @FindBy(xpath = "//*[@id=\"user_login\"]")
    private WebElement nameForRegistration;

    public void inputNameForRegistration(String newName) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_login\"]")));
        nameForRegistration.clear();
        nameForRegistration.sendKeys(newName);
    }

    public boolean checkLoginAndPassFields(String login, String pass) {
        String testLogin = loginField.getAttribute("value");
        String testPass = passwdField.getAttribute("value");

        return loginField.getAttribute("value").equals(login) && passwdField.getAttribute("value").equals(pass);
    }


}