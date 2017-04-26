import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
    WebDriver webDriver;

    public MorePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_extra_distance_units_state_text")
    private WebElement distanceUnitsStateText;

    @FindBy(xpath = "//android.widget.TextView[@text='Distance units']")
    private WebElement distanceUnitsState;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_extra_distance_units_miles_radio_button")
    private WebElement unitMiles;

    @FindBy(id = "ru.yandex.yandexmaps:id/settings_extra_distance_units_kilometers_radio_button")
    private WebElement unitKilometers;

    public WebElement getDistanceUnitsStateText() {
        return distanceUnitsStateText;
    }

    public WebElement getDistanceUnitsState() {
        return distanceUnitsState;
    }

    public WebElement getUnitMiles() {
        return unitMiles;
    }

    public WebElement getUnitKilometers() {
        return unitKilometers;
    }
}
