package Appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class Appium07_UI_Automator {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //13 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/HakanBatirhan/IdeaProjects/Appium_Lesson/src/Apps/Gesture_Tool_1.3_Apkpure.apk");
//        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
//        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivit");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        WebElement resourceId=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")");
        resourceId.click();

        /*
        yukaridaki WebElement resourceId elementinin farkli locate alma yontemi asagida
         */
//        WebElement resourceId=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)");
//        resourceId.click();
//
//        WebElement textButton=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")");
//        textButton.click();

                WebElement textButton=driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").startsWithText(\"Add\")");
        textButton.click();

        ReusableMethods.bekle(3);
            String  doneButton=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled").toString();
            System.out.println("doneButton durumu = " + doneButton);

        driver.closeApp();
    }
}
