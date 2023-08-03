package Appium;

import baseClass.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public class Appium09_UiSelector extends BaseClass {
    @Test
    public void test() throws MalformedURLException {

        AndroidDriver driver= getAndroidDriver_Emulator();
        WebElement resourceId = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")");
        resourceId.click();

        ReusableMethods.bekle(3);

        String isFalse = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled").toString();
        assertEquals(isFalse, "false");

        WebElement textBox= driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")");
        textBox.sendKeys("Hakan Kara");

        ReusableMethods.bekle(7);

        WebElement blackScreen= driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gestures_overlay\")");
        blackScreen.click();

        String isTrue = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)").getAttribute("enabled").toString();
        assertEquals(isTrue, "true");

        driver.closeApp();
    }
}
