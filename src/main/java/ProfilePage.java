import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"contentArea\"]/section/header/div/div[1]/h1/span[1]")
    private WebElement profileName;

    public boolean checkProfileName(String name) {
        return profileName.getText().equals(name);
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/aside/section[1]/div/div[2]")
    private WebElement profileCity;

    public boolean checkCity(String city) {
        return profileCity.getText().equals(city);
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/aside/section[1]/div/div[1]")
    private WebElement profileAboutMe;

    public boolean checkAboutMe(String aboutMe) {
        return profileAboutMe.getText().equals(aboutMe);
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/aside/section[1]/div/div[3]")
    private WebElement profileSite;

    public boolean checkSite(String site) {
        return profileSite.getText().equals(site);
    }

    @FindBy(xpath = "//*[@id=\"contentArea\"]/div/aside/section[1]/div/div[4]/ul/li/a")
    private WebElement profileHashTags;

    public boolean checkHashTags(String hashTags) {
        return profileHashTags.getText().equals(hashTags);
    }


    @FindBy(xpath = "//*[@id=\"contentArea\"]/section/header/div/div[1]/span/span")
    private WebElement profileID;

    public boolean checkProfileID(String ID) {
        String st = profileID.getText();
        return profileID.getText().equals(ID);
    }

}
