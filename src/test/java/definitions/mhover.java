package definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static support.TestContext.getDriver;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;


public class mhover {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.usps.com/");
        WebElement ele;
        ele = driver.findElement(By.id("//a[@id='mail-ship-width']"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

}
