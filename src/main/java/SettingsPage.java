import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"user_name\"]")
    private WebElement name;

    public void changeName(String newName) {
        name.clear();
        name.sendKeys(newName);
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/div/section/div[4]/input[1]")
    private WebElement changeSettingsButton;

    public void clickOnChangeSettingsButton() {
        changeSettingsButton.click();
    }

    @FindBy(xpath = "//*[@id=\"user_location\"]")
    private WebElement location;

    public void changeLocation(String newLocation) {
        location.clear();
        location.sendKeys(newLocation);
    }

    @FindBy(xpath = "//*[@id=\"user_about_me\"]")
    private WebElement aboutMe;

    public void changeAboutMe(String newAboutMe) {
        aboutMe.clear();
        aboutMe.sendKeys(newAboutMe);
    }

    @FindBy(xpath = "//*[@id=\"user_website\"]")
    private WebElement site;

    public void changeSite(String newSite) {
        site.clear();
        site.sendKeys(newSite);
    }

    @FindBy(xpath = "//*[@id=\"interest_settings\"]/label")

    private WebElement interests;

    public void changeInterests(String newInterests) {
        //interests.clear();
        interests.sendKeys(newInterests);
    }

}
