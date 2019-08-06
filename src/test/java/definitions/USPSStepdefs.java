package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void iClickMailShip() throws InterruptedException {
//        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        action.moveToElement(element).perform();
        Thread.sleep(2000);
    }

    @And("I click Lookup a ZIP Code")
    public void iClickLookupAZIPCode() throws InterruptedException {
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(text(),'Look Up a ZIP Code')]")).click();
//        getDriver().findElement(By.xpath("//a[@class='button--link'][contains(text(),'Look Up a ZIP Code')]")).click();
        Thread.sleep(2000);
    }

    @And("I click Find by Address")
    public void iClickFindByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();
//        getDriver().findElement(By.xpath("//a[contains(@href,'ZIP')]")).click();
        Thread.sleep(2000);
    }

    @Then("I fill out Form")
    public void iFillOutForm() throws InterruptedException {
        String state = "CA";
//        getDriver().findElement(By.xpath("//input[@id='tCompany']")).sendKeys("Portnov Computer School");
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys("Los Altos");
//        getDriver().findElement(By.xpath("//select[@id='tState']//option[contains(text(),'CA - " + state + "')]")).click();
        WebElement dropdown = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(dropdown).selectByValue(state);
        Thread.sleep(2000);
    }

    @Then("I verify that my ZIP code is in the list")
    public void iVerifyThatMyZIPCodeIsInTheList() {
//        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText().contains("94022-1461"));
//        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='zipByAddressDiv']"), "94022-1461"));
//        wait.until(driver ->driver.findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText()!="");
        wait.until(driver -> !driver.findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText().isEmpty());
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
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option[@value='10150'][contains(text(),'" + country + "')]")).click();
//        getDriver().findElement(By.xpath("//input[@id='option_1'][")).click();
        getDriver().findElement(By.xpath("//div[@id='options-section']//div[@class='row']//div[1]//input[@value='" + shape + "']")).click();
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

    @When("I go to {string} tab")
    public void iGoToTab( String tab ) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + tab + "')]")).click();
    }

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch( String search ) {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(search);
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='no-results-found']"), "12345"));
    }

    @When("I go to Stamp and Supplies page")
    public void iGoToStampAndSuppliesPage() {
        WebElement element = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(element).perform();
    }

    @And("I open Stamps")
    public void iOpenStamps() {
        getDriver().findElement(By.xpath("//a[contains(text(),'Stamps & Supplies')]")).click();
    }

    @And("choose category Priority Mail")
    public void chooseCategoryPriorityMail() {
        getDriver().findElement(By.xpath("//li[contains(@class,'stamps-navigation')]//a//img")).click();
    }

    @Then("I verify {int} item found in the result")
    public void iVerifyItemFoundInTheResult( int amount ) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Priority Mail (" + amount + ")')]")));
    }

    @And("I open Stamps img")
    public void iOpenStampsImg() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class,'stamps-navigation')]//a//img"))).click();
    }


    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps']")).click();

    }

    @And("select size {string}")
    public void selectSize( String size ) throws InterruptedException {
        WebElement tmpElement = getDriver().findElement(By.xpath("//input[@id='checkbox-type-Size-"+size+"-11']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", tmpElement);
        Thread.sleep(3000);
    }

    //to fix
    @And("I click {string} color")
    public void iClickColor( String color ) throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='result-facid-holder-grid-color']//div[3]")).click();
        //div[@class='result-grid'][@style='background-color:#033366;']
        Thread.sleep(3000);
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters( String size, String color ) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+color+"')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+size+"')]")).isDisplayed());
    }

    @Then("I verify {string} sale")
    public void iVerifySale( String sale ) {
        int actualCount = getDriver().findElements(By.xpath("//div[@class='results-product-type']/p/strong/mark[contains(text(),'"+sale+"')]")).size();
        String text_sale = getDriver().findElements(By.xpath("//div[@class='results-product-type']/p/strong/mark[contains(text(),'"+sale+"')]")).get(1).getText();
//        System.out.println(text_sale);
        assertThat(text_sale).isEqualTo(sale);
        assertThat(actualCount).isEqualTo(6);
    }

    @When("I perform {string} search")
    public void iPerformSearch( String str) throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        new Actions(getDriver()).moveToElement(element).perform();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'"+str.toUpperCase()+"')]")).click();
    }

    //to fix
    @And("I select {string} in results")
    public void iSelectInResults( String res ) throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='title_20']"))).click();
    }


    @And("I click {string} button")
    public void iClickButton( String find ) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button--primary'][contains(text(),'"+find+"')]"))).click();
    }

    @And("I select {string} zip code within {string} and search")
    public void iSelectZipCodeWithinAndSearch( String zip, String dist ) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tCityStateZip']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//div[@id='sWithinList']//div[@class='select-current']")).click();
        WebElement tmpElement = getDriver().findElement(By.xpath("//div[@id='sWithinList']//a[contains(text(),'"+dist+"')]"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", tmpElement);
        Thread.sleep(10000);
//        WebElement tmpElement1 = getDriver().findElement(By.xpath("//input[@id='bSearch']"));
//        WebElement tmpElement1 = getDriver().findElement(By.xpath("//span[@class='button-link btn-reg btn-blue-reg']"));
//        WebElement tmpElement1 = getDriver().findElement(By.xpath("//span[@class='hasHover']"));
        //div[@id='quick-tools-container']
//        executor.executeScript("arguments[0].click();", tmpElement1);
//        getDriver().findElement(By.xpath("//div[@id='quick-tools-container']")).click();
        getDriver().findElement(By.xpath("//span[@class='hasHover']")).click();
//        Thread.sleep(10000);

    }

    @Then("I verify {string} present in search results")
    public void iVerifyPresentInSearchResults( String loc ) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='po-name'][contains(text(),'"+loc+"')]"))).isDisplayed();
        assertThat(getDriver().findElement(By.xpath("//span[@class='po-name'][contains(text(),'"+loc+"')]")).isDisplayed());
    }

    @When("I open {string} search results")
    public void iOpenSearchResults( String locopen ) {
        getDriver().findElement(By.xpath("//span[@class='po-name'][contains(text(),'"+locopen+"')]")).click();
    }

    @Then("I verify {string} address, {string} appointment hours, {string} photo hours")
    public void iVerifyAddressAppointmentHoursPhotoHours( String addr, String hoursa, String hoursp ) {
        getDriver().findElement(By.xpath("//span[@id='addressDisp']")).click();
        assertThat(getDriver().findElement(By.xpath("//span[@id='addressDisp']")).getText().contains(addr));
        assertThat(getDriver().findElement(By.xpath("//div[@id='passportApptHours']//div//ul")).getText().contains(hoursa));
        assertThat(getDriver().findElement(By.xpath("//div[@id='passportPhotoHours']//div")).getText().contains(hoursp));
    }

    @When("I go back to list")
    public void iGoBackToList() {
        getDriver().navigate().back();
    }

    @Then("I verify I'm on Find Locations search page")
    public void iVerifyIMOnFindLocationsSearchPage() {
        getDriver().findElement(By.xpath("//h1[contains(text(),'Find Locations')]"));
    }



//    @Then("I verify {int} item found in result")
//    public void iVerifyItemFoundInResult(int count) {
//        int actualCount = getDriver().findElements(By.xpath("//div[@class='result-page-stamps-holder ']")).size();
//        assertThat(actualCount).isEqualTo(count);
//    }


}
