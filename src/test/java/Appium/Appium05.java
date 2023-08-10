package Appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\Calculator.apk");

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

    @Test
    public void test2() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //10 kismi kullanilacak telefondaki Android versionudur.
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice"); IOS'da RealDevice yerine cmd de "adb device" yazinca cikan kodu girecegiz
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Lesson\\src\\Apps\\Calculator.apk");

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

         sifir= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_0')]"));
         dokuz= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_9')]"));
         sekiz= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_8')]"));
         yedi= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_7')]"));
         alti= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_6')]"));
         bes= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_5')]"));
         dort= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_4')]"));
         uc= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_3')]"));
         iki= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_2')]"));
         bir= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_1')]"));
         divide= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_div')]"));
         multiply= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_mul')]"));
         minus= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_sub')]"));
        WebElement add= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_add')]"));
        WebElement equal= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/eq')]"));

        dokuz.click();
        uc.click();
        add.click();
        yedi.click();
        equal.click();
        multiply.click();
        iki.click();
        equal.click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement addGestureButton = wait.until(ExpectedConditions.visibilityOf(score));
        WebElement score= driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.google.android.calculator:id/result_final')]"));

        assertEquals(score.getText(),"200");

        driver.closeApp();
    }
}