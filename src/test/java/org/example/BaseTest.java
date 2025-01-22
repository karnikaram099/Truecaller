package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    private AppiumDriverLocalService service;
    PageClass pageClass;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZD2223SFNJ"); // Ensure this is the correct device name
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability("appWaitPackage", "com.truecaller");
            cap.setCapability("appWaitActivity", "com.truecaller.ui.WizardActivity");
            cap.setCapability("appPackage", "com.truecaller");
            cap.setCapability("appActivity", "com.truecaller.ui.TruecallerInit");
            cap.setCapability("appWaitDuration", "50000");
            cap.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Driver initialized...");

            pageClass = new PageClass(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
