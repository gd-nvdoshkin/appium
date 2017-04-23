import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by nvdoshkin on 21/04/2017.
 */
public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ru.yandex.yandexmaps:id/map_navigation_controls_menu_button")
    private WebElement menu;

    @FindBy(id = "ru.yandex.yandexmaps:id/map_traffic_level_button_text")
    private WebElement traffic;

    @FindBy(id = "ru.yandex.yandexmaps:id/map_controls_zoom_in_button")
    private WebElement zoomIn;

    @FindBy(id = "ru.yandex.yandexmaps:id/map_controls_zoom_out_button")
    private WebElement zoomOut;

    @FindBy(id = "ru.yandex.yandexmaps:id/map_navigation_controls_routes_button")
    private WebElement controlRoutes;

    @FindAll({@FindBy(id = "ru.yandex.yandexmaps:id/routes_setup_waypoint_text")})
    private List<WebElement> setupWaypoints;

    @FindBy(id = "ru.yandex.yandexmaps:id/routes_setup_ab_view_waypoint_b")
    private WebElement setupWaypointB;

    @FindBy(id ="ru.yandex.yandexmaps:id/map_point_selection_complete_button")
    private WebElement mapPointComplete;

    @FindBy(id = "ru.yandex.yandexmaps:id/routes_selection_base_selection_complete_button")
    private WebElement completeRoute;

    @FindBy(id= "ru.yandex.yandexmaps:id/routes_directions_car_directions_map_controls_add_road_event_button")
    private WebElement addRoadEvent;

    @FindBy(id = "ru.yandex.yandexmaps:id/view_add_road_event_send_button")
    private WebElement sendRoadEvent;

    @FindAll({@FindBy(id = "ru.yandex.yandexmaps:id/status_error_clear_button")})
    private List<WebElement> errorClearButons;

    @FindBy(id = "ru.yandex.yandexmaps:id/routes_directions_car_directions_bar_reset")
    private WebElement resetRoute;

    public List<WebElement> getErrorClearButons() {
        return errorClearButons;
    }

    public WebElement getResetRoute() {
        return resetRoute;
    }

    public WebElement getAddRoadEvent() {
        return addRoadEvent;
    }

    public WebElement getSendRoadEvent() {
        return sendRoadEvent;
    }

    public WebElement getControlRoutes() {
        return controlRoutes;
    }

    public List<WebElement> getSetupWaypoints() {
        return setupWaypoints;
    }

    public WebElement getSetupWaypointB() {
        return setupWaypointB;
    }

    public WebElement getMapPointComplete() {
        return mapPointComplete;
    }

    public WebElement getCompleteRoute() {
        return completeRoute;
    }

    public WebElement getZoomOut() {
        return zoomOut;
    }

    public WebElement getZoomIn() {
        return zoomIn;
    }

    public WebElement getTraffic() {
        return traffic;
    }

    public WebElement getMenu() {
        return menu;
    }
}
