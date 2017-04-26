import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Step {
    public static final String username = "formobiletesting";
    public static final String password = "MobileTesting";
    public static final String STRING_ON_VALUE = "On";
    public static final String STRING_OFF_VALUE = "Off";
    public static final String STRING_TRUE_VALUE = "true";
    public static final String STRING_FALSE_VALUE = "false";

    MainPage mainPage;
    SettingsPage settingsPage;
    MenuPage menuPage;
    LogInPage logInPage;
    MorePage morePage;
    AndroidDriver<AndroidElement> driver;


    public Step(AndroidDriver<AndroidElement> driver) {
        this.mainPage = new MainPage(driver);
        this.menuPage = new MenuPage(driver);
        this.morePage = new MorePage(driver);
        this.settingsPage = new SettingsPage(driver);
        this.logInPage = new LogInPage(driver);
        this.driver = driver;
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Open Settings menu")
    protected void openSettings() {
        mainPage.getMenu().click();
        menuPage.getSettings().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Click on traffic button")
    protected void clickOnTrafficButton() {
        mainPage.getTraffic().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Click on zoomIn and zoomOut")
    protected void performZoomActions() {
        mainPage.getZoomIn().click();
        mainPage.getZoomOut().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Log in Yandex's account")
    protected void logIn() {
        settingsPage.getLogIn().click();
        settingsPage.getChooseAnotherAccount().click();
        logInPage.getLogin().sendKeys(username);
        logInPage.getPassword().sendKeys(password);
        logInPage.getLogInButton().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Wait until avatar exist")
    protected void waitUntilAvatarExist() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ru.yandex.yandexmaps:id/settings_auth_user_profile_picture")));
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Scroll to button")
    protected void scrollTo(String text) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Press to logOut button and confirm")
    protected void logOut() {
        settingsPage.getLogOut().click();
        settingsPage.getPositiveButton().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Enable night mode")
    protected void enableNightMode() {
        assertEquals(STRING_OFF_VALUE, settingsPage.getNightMode().getText());
        settingsPage.getNightMode().click();
        settingsPage.getNigthModeOn().click();
        assertEquals(STRING_ON_VALUE, settingsPage.getNightMode().getText());
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Disable night mode")
    protected void disableNightMode() {
        assertEquals(STRING_ON_VALUE, settingsPage.getNightMode().getText());
        settingsPage.getNightMode().click();
        settingsPage.getNightModeOff().click();
        assertEquals(STRING_OFF_VALUE, settingsPage.getNightMode().getText());
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Enable all available types of map by turns")
    protected void mapTypeChanging() {
        mainPage.getMenu().click();
        assertEquals(STRING_FALSE_VALUE, menuPage.getSatellite().getAttribute("checked"));
        menuPage.getSatellite().click();
        assertEquals(STRING_TRUE_VALUE, menuPage.getSatellite().getAttribute("checked"));
        assertEquals(STRING_FALSE_VALUE, menuPage.getHybrid().getAttribute("checked"));
        menuPage.getHybrid().click();
        assertEquals(STRING_TRUE_VALUE, menuPage.getHybrid().getAttribute("checked"));
        assertEquals(STRING_FALSE_VALUE, menuPage.getMap().getAttribute("checked"));
        menuPage.getMap().click();
        assertEquals(STRING_TRUE_VALUE, menuPage.getMap().getAttribute("checked"));
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Create route using points on map")
    protected void createRoute() {
        mainPage.getControlRoutes().click();
        mainPage.getSetupWaypoints().get(0).click();
        mainPage.getSetupWaypointB().click();
        mainPage.getMapPointComplete().click();

        mainPage.getSetupWaypoints().get(1).click();
        mainPage.getSetupWaypointB().click();
        mainPage.getMapPointComplete().click();

        mainPage.getCompleteRoute().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Add accident on map")
    protected void addAccident() {
        mainPage.getAddRoadEvent().click();
        mainPage.getSendRoadEvent().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Reset created route")
    protected void resetRoute() {
        if (!mainPage.getErrorClearButons().isEmpty()) {
            mainPage.getErrorClearButons().get(0).click();
        }
        mainPage.getResetRoute().click();
    }

    @ru.yandex.qatools.allure.annotations.Step(value = "Switch all available units")
    protected void changeUnits() {
        settingsPage.getMoreButton().click();
        assertEquals("Kilometers", morePage.getDistanceUnitsStateText().getAttribute("text"));
        morePage.getDistanceUnitsState().click();
        morePage.getUnitMiles().click();
        assertEquals("Miles", morePage.getDistanceUnitsStateText().getAttribute("text"));
        morePage.getDistanceUnitsState().click();
        morePage.getUnitKilometers().click();
    }
}

