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
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class Appium06_Native_Chrome {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //10 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
       capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        //alttaki kod, applicasyonu izinler atlayarak ana sayfada acmak icin
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println(driver.getContext() + "driver acildigindaki tur");

        //application'un butun turlerini Set objesine koyduk ve yazdirdik
        Set <String> butunApplicationTurleri= driver.getContextHandles();

        for (String tur:butunApplicationTurleri){
            System.out.println("Butun application turleri = " + tur);
            if (tur.contains("WEBVIEW_chrome"))
                driver.context(tur);
        }

        ReusableMethods.bekle(2);
        try {
            WebElement homeScreenLogo= driver.findElement(By.id("nav-logo-sprites"));
            assertTrue(homeScreenLogo.isDisplayed());
        }catch (Exception e) {}

        System.out.println("Amazon sitesine gidildi");

        ReusableMethods.bekle(2);
        try {
        WebElement signInButton= driver.findElement(By.xpath("//android.view.View[@text='Giriş Yap ›']"));
        signInButton.click();
            System.out.println("Sign In butonuna basildi");
        }catch (Exception e) {}

        ReusableMethods.bekle(2);
        WebElement hosGeldinizText= driver.findElement(By.xpath("//android.view.View[@text='Hoş Geldiniz']"));
        assertTrue(hosGeldinizText.isDisplayed());
        System.out.println("Sign In yapildi");

        driver.closeApp();
    }
    @Test
    public void test2() throws MalformedURLException {
        //Bu test Native testini telefonda yapmak icin

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); //10 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        //alttaki kod, applicasyonu izinler atlayarak ana sayfada acmak icin
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println(driver.getContext() + "driver acildigindaki tur");

        //application'un butun turlerini Set objesine koyduk ve yazdirdik
        Set <String> butunApplicationTurleri= driver.getContextHandles();

        for (String tur:butunApplicationTurleri){
            System.out.println("Butun application turleri = " + tur);
             if (tur.contains("WEBVIEW_chrome"))
            //   if (tur.contains("NATIVE_APP"))
                driver.context(tur);
        }
        System.out.println(driver.getContext() + "driver'in kapanmadan onceki turu");

ReusableMethods.bekle(5);
        driver.closeApp();
    }

}
