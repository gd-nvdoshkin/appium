import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    AndroidDriver<AndroidElement> driver;
    AppiumServer appiumServer;
    Step step;

    @BeforeClass(alwaysRun = true, groups = "default")
    public void beforeSuit() throws MalformedURLException {

        ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--address", "127.0.0.1");
        serverArguments.setArgument("--no-reset", true);
        serverArguments.setArgument("--local-timezone", true);
        serverArguments.setArgument("--local-timezone", true);
        appiumServer = new AppiumServer(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"), new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js"), serverArguments);
        appiumServer.startServer();

        File appDir = new File("src");
        File app = new File(appDir, "maps.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        step = new Step(driver);

    }


    @AfterClass(alwaysRun = true, groups = "default")
    public void afterSuite(){
        driver.pressKeyCode(AndroidKeyCode.HOME);
        appiumServer.stopServer();
    }


}