package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class Appium03 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/HakanBatirhan/IdeaProjects/Appium_Lesson/src/Apps/Gesture_Tool_1.3_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app yuklendi");

        //kilitli ekrani acma kodu
        if(driver.isDeviceLocked()){
            driver.unlockDevice();
        }
        ReusableMethods.bekle(5);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement gentureToolText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
        assertTrue(gentureToolText.isDisplayed());


        WebElement testButton = driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton"));
        testButton.click();

        System.out.println("Test Button calisiyor");

        ReusableMethods.bekle(2);

        WebElement testAGesture = driver.findElement(By.id("android:id/title"));
        assertTrue(testAGesture.isDisplayed());

        System.out.println("Test A Gesture texti gorunuyor");

        driver.hideKeyboard(); //klavyeyi saklamak icin

        //session kapat
        driver.closeApp();
    }
}
