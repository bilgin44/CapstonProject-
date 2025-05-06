package Take_A_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FaceBook_Screenshot {

    public static void main(String[] args) throws IOException {
        //open the Chrome browser
        WebDriver driver = new ChromeDriver();
//
        driver.manage().window().maximize();
//        Navigate  to facebook.com
        driver.get("https://www.facebook.com/");
//       Capture Screenshot.
        TakesScreenshot ss=(TakesScreenshot) driver;

//        taking the ss
        File screenshot = ss.getScreenshotAs(OutputType.FILE);
//        save the screenshot in the specific folder
        FileUtils.copyFile(screenshot,new File("screenshot/mistakes.png"));
//      close the browser
        driver.quit();
    }
}