package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class MobileBrowserTest {
    @Test
    public void testName() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        //desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\chromedriver.exe");

        //appium url'ine baglanma
        AndroidDriver<AndroidElement> driver= new AndroidDriver(new URL("http://localhost:4723"), desiredCapabilities);

        driver.get("https://www.amazon.com.tr");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement amazonLogo= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='Amazon']")));

        assertTrue(amazonLogo.isDisplayed());
    }
}
