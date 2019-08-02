package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class USPSStepdefs {
    @Given("I go to {string} page new")
    public void iGoToPage( String page ) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com");
                break;
            case "yahoo":
                getDriver().get("https://www.yahoo.com/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            default:
                throw new RuntimeException("Unsupported page: " + page);

        }
    }

    @Then("I click Mail&Ship")
    public void iClickMailShip() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
    }

    @And("I click Lookup a ZIP Code")
    public void iClickLookupAZIPCode() {
        getDriver().findElement(By.xpath("//a[@class='button--link'][contains(text(),'Look Up a ZIP Code')]")).click();
    }

    @And("I click Find by Address")
    public void iClickFindByAddress() {
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();
//        getDriver().findElement(By.xpath("//a[contains(@href,'ZIP')]")).click();
    }

    @Then("I fill out Form")
    public void iFillOutForm() {
        String state = "California";
//        getDriver().findElement(By.xpath("//input[@id='tCompany']")).sendKeys("Portnov Computer School");
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys("Los Altos");
        getDriver().findElement(By.xpath("//select[@id='tState']//option[contains(text(),'CA - " + state + "')]")).click();
    }

    @Then("I verify that my ZIP code is in the list")
    public void iVerifyThatMyZIPCodeIsInTheList() {
        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText().contains("94022-1461"));
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        action.moveToElement(element).perform();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(text(),'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape( String country, String shape ) throws InterruptedException {
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option[@value='10150'][contains(text(),'"+country+"')]")).click();
//        getDriver().findElement(By.xpath("//input[@id='option_1'][")).click();
        getDriver().findElement(By.xpath("//div[@id='options-section']//div[@class='row']//div[1]//input[@value='"+shape+"']")).click();
        Thread.sleep(1000);
    }

    @And("I define {string} quantity")
    public void iDefineQuantity( String quantity ) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs( String price ) {
        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='cost-0']")).getText().contains(price));
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText().contains(price));
    }
}
