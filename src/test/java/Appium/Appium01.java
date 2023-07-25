package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities= new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        /*
        yukaridaki 2 kod da asagidaki kodun gorevini yapar. Herhangi birini yazsak olur.
         */
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //13 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/HakanBatirhan/IdeaProjects/Appium_Lesson/src/Apps/Gesture Tool_1.3_Apkpure.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}
