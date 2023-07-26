package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class Appium04 {
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

        WebElement alti=driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        alti.click();
        System.out.println("alti rakamina basildi");

        WebElement bes=driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        bes.click();
        System.out.println("bes rakamina basildi");

        WebElement artiButonu=driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        artiButonu.click();
        System.out.println("arti butonuna basildi");

        WebElement yedi=driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        yedi.click();
        System.out.println("yedi rakamina basildi");

        WebElement dokuz=driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        dokuz.click();
        System.out.println("dokuz rakamina basildi");

        WebElement esittirButonu=driver.findElement(By.id("com.google.android.calculator:id/eq"));
        artiButonu.click();
        System.out.println("esittir butonuna basildi");

        WebElement result= driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String expectedResult="144";
        String actualResult=result.getText();
        assertEquals(expectedResult,actualResult );
        System.out.println("sonuc dogrulandi");


    }
}
