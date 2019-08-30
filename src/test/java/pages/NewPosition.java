package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

import java.util.Map;
import java.io.FileNotFoundException;

import support.TestContext;

import static support.TestContext.getData;

public class NewPosition extends Page {
    @FindBy(xpath = "//input[@placeholder='Enter position Title']")
    private WebElement title;

    @FindBy(xpath = "//textarea[@placeholder='Enter detailed Description']")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement city;

    @FindBy(xpath = "//select[@class='form-control']")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionState']/../select/option[6]")
    private WebElement stateCalifornia;

    @FindBy(xpath = "//input[@placeholder='Zip code. Zip plus']")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;

    @FindBy(xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement todayButton;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submit;


    public NewPosition createPosition( String position ) throws FileNotFoundException {
        this.title.sendKeys(getData(position).get("title"));
        this.description.sendKeys(getData(position).get("description"));
        this.address.sendKeys(getData(position).get("address"));
        this.city.sendKeys(getData(position).get("city"));
        this.zip.sendKeys(getData(position).get("zip"));
        stateCalifornia.click();
        dateOpen.click();
        todayButton.click();
        submit.click();
        return new NewPosition();
    }
}
