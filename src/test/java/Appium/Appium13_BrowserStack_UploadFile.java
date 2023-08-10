package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class Appium13_BrowserStack_UploadFile {
    @Test
    public void testName() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "hakankara_If5348");
        caps.setCapability("browserstack.key", "qsn7wbGdRMkxtxBDhzqw");

        // Set URL of the application under test
        caps.setCapability("app", "bs://6b077aeb4b2e87d54f2ef2f7bae4c5d119edd192");
        caps.setCapability("platformName", "Android");
        // Specify device and os_version for testing
        caps.setCapability("deviceName", "Xiaomi Redmi Note 11");
        caps.setCapability("os_version", "11.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Appium Upload Project");
        caps.setCapability("build", "browserstack-1");
        caps.setCapability("name", "Calculator_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);


        WebElement sifir= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_0')]"));
        WebElement dokuz= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_9')]"));
        WebElement sekiz= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_8')]"));
        WebElement yedi= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_7')]"));
        WebElement alti= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_6')]"));
        WebElement bes= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_5')]"));
        WebElement dort= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_4')]"));
        WebElement uc= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_3')]"));
        WebElement iki= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_2')]"));
        WebElement bir= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/digit_1')]"));
        WebElement divide= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_div')]"));
        WebElement multipy= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_mul')]"));
        WebElement sub= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_sub')]"));
        WebElement add= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/op_add')]"));
        WebElement equal= driver.findElement(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.google.android.calculator:id/eq')]"));

        dokuz.click();
        uc.click();
        add.click();
        yedi.click();
        equal.click();
        multipy.click();
        iki.click();
        equal.click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement addGestureButton = wait.until(ExpectedConditions.visibilityOf(score));
        WebElement score= driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'com.google.android.calculator:id/formula')]"));

        assertEquals(score.getText(),"200");




    }
}
