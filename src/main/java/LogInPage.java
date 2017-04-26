import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver webDriver;

    public LogInPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ru.yandex.yandexmaps:id/am_credentials_login_input")
    private WebElement login;

    @FindBy(id="ru.yandex.yandexmaps:id/am_credentials_password_input")
    private WebElement password;

    @FindBy(id="ru.yandex.yandexmaps:id/am_credentials_login_button")
    private WebElement logInButton;

    public WebElement getLogin() {
        return login;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
