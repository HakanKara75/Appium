package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class HepsiBurada {
    @Test
    public void hepsiBurada() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME ,"RealDevice");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION ,"13");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME ,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP ,"C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\hepsiburada.apk");

        //appium url'ine baglanma
        AndroidDriver<AndroidElement> driver= new AndroidDriver<AndroidElement>(new URL("http://localhost:4723"), desiredCapabilities);

        MobileElement allow=driver.findElement(By.xpath("//android.widget.Button[@text='Allow"));
        allow.click();
        MobileElement search= driver.findElement(By.id("com.pozitron.hepsiburada:id/etSearchBox"));
        search.sendKeys("karaca");
    }
}
