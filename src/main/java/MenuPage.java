import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    WebDriver webDriver;

    public MenuPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private WebElement settings;

    @FindBy(id ="ru.yandex.yandexmaps:id/map_type_satellite_button")
    private WebElement satellite;

    @FindBy(id="ru.yandex.yandexmaps:id/map_type_hybrid_button")
    private WebElement hybrid;

    @FindBy(id = "ru.yandex.yandexmaps:id/map_type_map_button")
    private WebElement map;

    public WebElement getSatellite() {
        return satellite;
    }

    public WebElement getHybrid() {
        return hybrid;
    }

    public WebElement getMap() {
        return map;
    }

    public WebElement getSettings() {
        return settings;
    }
}
