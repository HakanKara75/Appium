package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

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
        AndroidDriver<AndroidElement> driver= new AndroidDriver(new URL("http://localhost:4723"), desiredCapabilities);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement allow= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Allow")));
        allow.click();

        WebElement search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.pozitron.hepsiburada:id/etSearchBox")));
        search.sendKeys("karaca");
    }

    @Test
    public void hepsiBurada2() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME ,"RealDevice");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION ,"13");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME ,"UiAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.hepsiburada.ui.startup.SplashActivity");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.pozitron.hepsiburada");

        //appium url'ine baglanma
        AndroidDriver<AndroidElement> driver= new AndroidDriver(new URL("http://localhost:4723"), desiredCapabilities);

        WebDriverWait wait = new WebDriverWait(driver, 20);

//        WebElement allow= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Allow")));
//        allow.click();

        WebElement search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.pozitron.hepsiburada:id/etSearchBox")));
        search.sendKeys("karaca");
    }
}
