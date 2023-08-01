package Appium;

import baseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Appium11 extends BaseClass {
    @Test
    public void testName() throws MalformedURLException {
        AndroidDriver driver= getAndroidDriver_Emulator();
        System.out.println("Aplication calisti");

        WebElement preference= driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        preference.click();
        System.out.println("Preference linki tiklandi");

        WebElement preferenceDependencies= driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        preferenceDependencies.click();
        System.out.println("Preference Dependencies linki tiklandi");

        String isFalse = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println("isFalse = " + isFalse);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement wifiCheckbox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/checkbox")));

        if (isFalse.equals("false")){
            wifiCheckbox.click();}
        System.out.println("Wifi Checkbox tiklandi");

        WebElement wifiSettings= driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettings.click();
        System.out.println("Wifi Settings linki tiklandi");

        WebElement wifiSettingsText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
             System.out.println("Wifi Settings Text alerti goruldu");

        WebElement wifiSettingsTextBox= driver.findElementById("android:id/edit");
        wifiSettingsTextBox.sendKeys("Hakan Kara");
        System.out.println("Wifi Settings Text kutusuna metin gonderildi");

        WebElement okButton= driver.findElementById("android:id/button1");
        okButton.click();
        System.out.println("OK Butonuna basildi");

        driver.closeApp();
        System.out.println("Aplication kapatildi");
    }
}

