import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nvdoshkin on 21/04/2017.
 */
public class SettingsPage {
    WebDriver webDriver;

    public SettingsPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_auth_login_button")
    private WebElement logIn;

    @FindBy(id = "ru.yandex.yandexmaps:id/amAddButton")
    private WebElement chooseAnotherAccount;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_auth_logout_button")
    private WebElement logOut;

    @FindBy(id = "ru.yandex.yandexmaps:id/common_dialog_positive_button")
    private WebElement positiveButton;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_setup_night_mode_state_text")
    private WebElement nightMode;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_night_mode_on_radio_button")
    private WebElement nigthModeOn;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_night_mode_off_radio_button")
    private WebElement nightModeOff;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_extras_button")
    private WebElement moreButton;

    public WebElement getMoreButton() {
        return moreButton;
    }

    public WebElement getLogOut() {
        return logOut;
    }

    public WebElement getPositiveButton() {
        return positiveButton;
    }

    public WebElement getLogIn() {
        return logIn;
    }

    public WebElement getChooseAnotherAccount() {
        return chooseAnotherAccount;
    }

    public WebElement getNightMode() {
        return nightMode;
    }

    public WebElement getNigthModeOn() {
        return nigthModeOn;
    }

    public WebElement getNightModeOff() {
        return nightModeOff;
    }
}
