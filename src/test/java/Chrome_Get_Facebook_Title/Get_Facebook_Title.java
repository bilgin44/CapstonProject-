package Chrome_Get_Facebook_Title;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Get_Facebook_Title {
    public static void main(String[] args) throws InterruptedException {
// instance of chromeDriver
        WebDriver driver =new ChromeDriver();

//        Step1 : open the Chrome browser. used chrome driver to open chrome browser
//        Step2 : navigate to url of Facebook. this line opens to the facebook homepage
        driver.get("https://www.facebook.com/");

//        Step3 : maximize the window. To make sure the browser opens fully for a better view
        driver.manage().window().maximize();


//        Step4: gets the title of the webpage and print it to the console to verify that the correct page loaded
        String title = driver.getTitle();
        System.out.println("The title of the Facebook webpage is "+title);
//        Added a short wait so the browser does not close too quickly.
        Thread.sleep(1000);



        driver.quit();

    }
}