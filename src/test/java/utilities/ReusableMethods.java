package utilities;

import static org.testng.AssertJUnit.*;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    public class ReusableMethods {

        private static Connection connection;
        private static Statement statement;
        private static ResultSet resultSet;


        //HARD WAIT METHOD
        public static void bekle(int saniye){
            try {
                Thread.sleep(saniye*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         *       Tüm Sayfa ScreenShot
         */

        public static void tumSayfaScreenShoot(AndroidDriver driver){
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "TestOutput/screenshot"+tarih+".png";
            TakesScreenshot ts = (TakesScreenshot) driver;
            try {
                FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         *   WebElement ScreenShot
         *   @param element screenshot'i alinacak elementin locatidir
         */

        public static void webElementScreenShoot(WebElement element){
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "TestOutput/webElementScreenshot"+tarih+".png";
            try {
                FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}
