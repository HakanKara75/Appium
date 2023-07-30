package Appium;

import baseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public class Appium08_UiSelector extends BaseClass {
    @Test
    public void test() throws MalformedURLException {

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //13 kismi kullanilacak telefondaki Android versionudur.
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/HakanBatirhan/IdeaProjects/Appium_Lesson/src/Apps/Gesture_Tool_1.3_Apkpure.apk");
//        capabilities.setCapability("noReset", true);
//        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        AndroidDriver driver= getAndroidDriver_Emulator();
        WebElement resourceId = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")");
        resourceId.click();

        ReusableMethods.bekle(3);
        String doneButton = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled").toString();

        assertEquals(doneButton, "false");

        driver.closeApp();
    }
}
