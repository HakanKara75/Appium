package Appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class Appium05 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //10 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        //alttaki kod, applicasyonu izinler atlayarak ana sayfada acmak icin
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app yuklendi");

        WebElement bir = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement iki = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement uc = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement dort = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        WebElement bes = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        WebElement alti = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        WebElement yedi = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        WebElement sekiz = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        WebElement dokuz = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        WebElement sifir = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));

        WebElement plus = driver.findElementByAccessibilityId("plus");
        WebElement minus = driver.findElementByAccessibilityId("minus");
        WebElement multiply = driver.findElementByAccessibilityId("multiply");
        WebElement divide = driver.findElementByAccessibilityId("divide");
        WebElement equals = driver.findElementByAccessibilityId("equals");

        //64+71

        alti.click();
        dort.click();
        plus.click();
        yedi.click();
        bir.click();
        equals.click();
        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        String expectedResult="135";
        String actualResult=result.getText();
        assertEquals(actualResult, expectedResult);
        System.out.println("sonuc dogrulandi");
        driver.closeApp();
    }
}