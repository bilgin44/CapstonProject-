package Facebook_Sign_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.AIUtility;

import java.io.IOException;

public class Create_Facebook_Account {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(10000);

        String firstName = AIUtility.generateTestData("Generate a random realistic first name");
        String lastName = AIUtility.generateTestData("Generate a random realistic last name");
        String email = firstName + "." + lastName + "@example.com";

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_passwd__")).sendKeys("BinBir");

        // Continue as before...
    }
}
