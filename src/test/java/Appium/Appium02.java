package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        /*
        yukaridaki 2 kod da asagidaki kodun gorevini yapar. Herhangi birini yazsak olur.
         */
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //13 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/HakanBatirhan/IdeaProjects/Appium_Lesson/src/Apps/Gesture_Tool_1.3_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addGestureButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.davemac327.gesture.tool:id/addButton")));
        addGestureButton.click();

        ReusableMethods.bekle(3);
        WebElement nameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.davemac327.gesture.tool:id/gesture_name")));
        nameBox.sendKeys("Gunaydin Herkese");

        ReusableMethods.bekle(3);
        WebElement blackScreen = driver.findElement(By.id("com.davemac327.gesture.tool:id/gestures_overlay"));
        blackScreen.click();

        ReusableMethods.bekle(3);
        WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Done']")));
        done.click();

        ReusableMethods.bekle(3);
        WebElement gestureToolTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Gesture Tool']")));
        assertTrue(gestureToolTitle.isDisplayed());


    }
}
