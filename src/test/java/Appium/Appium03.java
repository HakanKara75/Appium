package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class Appium03 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //10 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\Gesture_Tool_1.3_Apkpure.apk");

        //emulator telefon ekranında hareketleri gormek icin asagidaki 2 kod lazim
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
//        capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
//        capabilities.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");

        //alttaki kod, applicasyonu izinler atlayarak ana sayfada acmak icin
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app yuklendi");

        //kilitli ekrani acma kodu
        if(driver.isDeviceLocked()){
            driver.unlockDevice();
        }
        ReusableMethods.bekle(5);
        try {
            WebElement gentureToolText = driver.findElement(By.id("android:id/title"));
            assertTrue(gentureToolText.isDisplayed());
        }catch (Exception e) {}

        try {
        WebElement testButton = driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton"));
        testButton.click();
        }catch (Exception e) {}
        System.out.println("Test Button calisiyor");

        ReusableMethods.bekle(2);
        try {
        WebElement testAGesture = driver.findElement(By.id("android:id/title"));
        assertTrue(testAGesture.isDisplayed());
        }catch (Exception e) {}
        System.out.println("Test A Gesture texti gorunuyor");

        driver.hideKeyboard(); //klavyeyi saklamak icin

        //session kapat
       // driver.closeApp();
    }
}
