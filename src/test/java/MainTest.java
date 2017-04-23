
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MainTest extends BaseTest {


    @Test(groups = "mainPage")
    public void clickTrafficButton() throws MalformedURLException {
        step.clickOnTrafficButton();
    }

    @Test(groups = "mainPage")
    public void zoomActions() throws MalformedURLException {
        step.performZoomActions();
    }

    @Test(dependsOnMethods = "logIn", dependsOnGroups = "registered", groups = "default")
    public void logOut() {
        step.openSettings();
        step.scrollTo("Log out");
        step.logOut();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ru.yandex.yandexmaps:id/settings_extras_button")));
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(groups = "registered")
    public void logIn() {
        step.openSettings();
        step.logIn();
        step.waitUntilAvatarExist();
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(groups = "registered", dependsOnMethods = "logIn")
    public void enableNightMode() {
        step.openSettings();
        step.enableNightMode();
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(groups = "registered", dependsOnMethods = "enableNightMode")
    public void disableNightMode() {
        step.openSettings();
        step.disableNightMode();
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(groups = "registered")
    public void mapTypeChanging() {
        step.mapTypeChanging();
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @Test(dependsOnMethods = "logOut", groups = "default")
    public void createRoute() {
        step.createRoute();

    }

    @Test(dependsOnMethods = "createRoute", groups = "default")
    public void addAccident() {
        step.addAccident();
    }

    @Test(dependsOnMethods = "addAccident", groups = "default")
    public void deleteRoute() {
        step.resetRoute();
    }

    @Test(dependsOnMethods = "deleteRoute", groups = "default")
    public void changeUnits() throws InterruptedException {
        step.openSettings();
        step.scrollTo("More");
        step.changeUnits();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        Thread.sleep(100);
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

}
