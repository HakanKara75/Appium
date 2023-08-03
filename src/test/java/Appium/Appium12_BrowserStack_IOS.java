package Appium;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium12_BrowserStack_IOS {

    @Test
    public void browserstackiOS() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "hakankara_If5348");
        caps.setCapability("browserstack.key", "qsn7wbGdRMkxtxBDhzqw");

        // Set URL of the application under test
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");


        // Set other BrowserStack capabilities
        caps.setCapability("project", "First IOS Project-5");
        caps.setCapability("build", "browserstack-build-5");
        caps.setCapability("name", "first_test-1");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver driver = new IOSDriver(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        WebElement textButton = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();
        WebElement textInput =  new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("hello@browserstack.com");
        Thread.sleep(5000);
        WebElement textOutput = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
            assert(true);
        else
            assert(false);

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}