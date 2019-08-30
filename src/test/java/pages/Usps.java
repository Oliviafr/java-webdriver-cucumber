package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Usps extends Page {

    public Usps() {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//a[@id='stampButton']")
    private WebElement stampsButton;

    @FindBy(xpath = "//a[@class='menuitem'][contains(text(),'Postal Store')]")
    private WebElement postalStoreLink;

    @FindBy(xpath = "//a[@id='orderButton']")
    private WebElement boxes;

    @FindBy(xpath = "//a[@id='quickMenuButtonShip']")
    private WebElement labels;

    @FindBy(xpath = "//input[@id='trackButton']")
    private WebElement tracking;


    public void clickStamps() {
        stampsButton.click();
    }

    public void clickBoxes() {
        boxes.click();
    }

    public void clickLabels() {
        labels.click();
    }

    public void clickTracking() {
        tracking.click();
    }


    public void mhoverpostalStore() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(postalStoreLink).perform();
        Thread.sleep(2000);
    }

    public void clickMenuItem(String menu){
        getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='"+menu+"']")).click();
    }

}