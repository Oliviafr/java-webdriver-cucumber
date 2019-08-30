package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.FlashPolicyHelper;
import support.TestContext;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class UPSStepdefs {

    @Given("I allow flash")
    public void iAllowFlash() {
        new FlashPolicyHelper(getDriver()).addSite("https://www.ups.com/");
    }
//    @And("I open Shipping menu")
//    public void iOpenShippingMenu() throws InterruptedException {
//        getDriver().findElement(By.xpath("//a[@id='ups-quickStartMenu']")).click();
//    }

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> driver.findElement(By.xpath("//a[@id='ups-menuLinks1']"))).click();
//        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks1']")).click();
    }

//    @And("I go to Create a Shipment")
//    public void iGoToCreateAShipment() throws InterruptedException {
//        WebElement tmpElement = getDriver().findElement(By.xpath("//a[@id='ups-quickStartShip']"));
//        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//        executor.executeScript("arguments[0].click();", tmpElement);
//        Thread.sleep(3000);
//    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[contains(@href,'ship?')][not(@id='ups-quickStartShip')]")).click();
    }

    @When("I fill out origin shipment form")
    public void iFillOutOriginShipmentForm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> driver.findElement(By.xpath("//section[@class='ups-section']//section[@class='ups-section']")).isDisplayed());
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Olivia");
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys("Ötto Kochler");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("339 Goldfield Pl");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("94582");
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"), "SAN RAMON"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'California')]")));
        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys("SAN RAMON");
        getDriver().findElement(By.xpath("//option[contains(text(),'California')]")).click();
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("aniles@merkl.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("4446667892");

//        wait.until(driver -> driver.findElement(By.xpath("//input[@id='origincity']")).getAttribute("value").length() !=0);
//        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(text(),'Calculate a Price')]")).click();

//        wait.until(driver -> driver.findElement(By.xpath("//input[@id='origincity']")).getAttribute("value").length() !=0);
//        assertThat(getDriver().findElement(By.xpath("//input[@id='origincity']")).getText().contains("SAN RAMON"));

//        assertThat(getDriver().findElement(By.xpath("//option[contains(text(),'California')]")).getText().contains("California"));

        //button[@id='nbsBackForwardNavigationContinueButton']
//        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
//        Set<String> handlesbefore= getDriver().getWindowHandles();
//        System.out.println(handlesbefore);
//        String savedTWindowHandle = getDriver().getWindowHandle();
//        getDriver().findElement(By.xpath("//button[contains(@onclick, 'window')]")).click();
//
//        Set<String> handlesafter= getDriver().getWindowHandles();
//        System.out.println(handlesafter);
//        for(String handle : getDriver().getWindowHandles())
//            getDriver().switchTo().window(handle);
//        String actualText = getDriver().findElement(By.xpath("//body")).getText();
//        assertThat(actualText).containsIgnoringCase(docname);
//        getDriver().switchTo().window(savedTWindowHandle);

//        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("Olivia");
//        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("340 Goldfield Pl");
//        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("94682");
//
//        assertThat(getDriver().findElement(By.xpath("//input[@id='destinationcity']")).getText().contains("SAN RAMON"));
//        assertThat(getDriver().findElement(By.xpath("//select[@id='destinationstate']/option[contains(text(),'California')]")).getText().contains("California"));
//        getDriver().findElement(By.xpath("//select[@id='destinationstate']/option[contains(text(),'California')]")).click();
//        Thread.sleep(3000);
//        //button[@id='nbsBackForwardNavigationContinueButton']
//        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();

//        getDriver().findElement(By.xpath("//option[contains(text(),'UPS Express Box - Medium')]")).click();
//        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("11");
//        getDriver().findElement(By.xpath("//input[@id='nbsPackageDeclaredValueField0']")).sendKeys("10");
//        getDriver().findElement(By.xpath("//label[@for='nbsReference1CheckboxAllPackages']")).click();
//        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
//        int actualCount = getDriver().findElements(By.xpath("//div[@class='results-product-type']/p/strong/mark[contains(text(),'"+sale+"')]")).size();
//        String text_sale = getDriver().findElements(By.xpath("//div[@class='results-product-type']/p/strong/mark[contains(text(),'"+sale+"')]")).get(1).getText();
///       System.out.println(text_sale);
//        assertThat(text_sale).isEqualTo(sale);
//        assertThat(actualCount).isEqualTo(6);
//        String pricesfromlist = getDriver().findElements(By.xpath("//strong[contains(text(),'$')]")).toString();
//        System.out.println(pricesfromlist);
        //strong[contains(text(),'$')]
    }


    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
        Thread.sleep(10000);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String origin = getDriver().findElement(By.xpath("//agent-summary")).getText();
        assertThat(origin).contains("Olivia");
        assertThat(origin).contains("Ötto Kochler");
        assertThat(origin).contains("339 Goldfield Pl");
        assertThat(origin).contains("SAN RAMON");
        assertThat(origin).contains("CA 94582");
        assertThat(origin).contains("94582");
        assertThat(origin).contains("aniles@merkl.com");
        assertThat(origin).contains("4446667892");
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        String name = getDriver().findElement(By.xpath("//input[@id='originname']")).getAttribute("value");
    }


    @When("I fill out second origin shipment form")
    public void iFillOutSecondOriginShipmentForm() throws FileNotFoundException, InterruptedException {
        Map<String, String> sender = TestContext.getData("sender");

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> driver.findElement(By.xpath("//section[@class='ups-section']//section[@class='ups-section']")).isDisplayed());
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys((sender.get("name")));
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys((sender.get("name")));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys((sender.get("street")));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys((sender.get("zip")));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"), (sender.get("city").toUpperCase())));
//        to fix
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),"+(sender.get("state"))+")]")));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys((sender.get("email")));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys((sender.get("phone")));
        Thread.sleep(10000);
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(driver -> driver.findElement(By.xpath("//section[@class='ups-section']//section[@class='ups-section']")).isDisplayed());
//        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Administrator");
//        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys("Administrator");
//        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("4970 El Camino Real");
//        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("94022");
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"),"LOS ALTOS"));
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'California')]")));
//        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("mail@example.com");
//        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890");

    }

    @Then("I verify second origin shipment fields submitted")
    public void iVerifySecondOriginShipmentFieldsSubmitted() throws FileNotFoundException {
        Map<String, String> sender = TestContext.getData("sender");
        String origin = getDriver().findElement(By.xpath("//agent-summary")).getText();
        assertThat(origin).contains((sender.get("name")));
        assertThat(origin).contains((sender.get("zip")));
        assertThat(origin).contains((sender.get("street")));
        assertThat(origin).contains((sender.get("city")).toUpperCase());
        assertThat(origin).contains((sender.get("email")));
        assertThat(origin).contains((sender.get("phone")));
    }

    @And("Put sample data to send")
    public void putSampleDataToSend() throws FileNotFoundException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> driver.findElement(By.xpath("//section[@class='ups-section']//section[@class='ups-section']")).isDisplayed());
        Map<String, String> receiver = TestContext.getData("receiver");
//        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("John Doe");
//        getDriver().findElement(By.xpath("//input[@id='destinationcontactName']")).sendKeys("John Doe");
//        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("870 7th Ave");
//        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("10019");
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='destinationcity']"),"NEW YORK"));
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.elementToBeSelected(By.xpath("//option[contains(text(),'New York')]")));
    }

    @And("I Select UPS Express Box – Small, {string} pound weight")
    public void iSelectUPSExpressBoxSmallPoundWeight( String weight ) {
        getDriver().findElement(By.xpath("//option[contains(text(),'UPS Express Box - Medium')]")).click();
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys(weight);
    }

    @When("I go to PO Boxes under Track & Manage")
    public void iGoToPOBoxesUnderTrackManage() {
        WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'Track & Manage')]"));
        new Actions(getDriver()).moveToElement(element).perform();
        getDriver().findElement(By.xpath("//a[contains(text(),'Rent or Renew PO Box')]")).click();
    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor( String zip ) {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//span[@class='icon-search']")).click();
    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent( String address ) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(driver -> driver.findElement(By.xpath("//span[contains(text(),'Los Altos')]")).isDisplayed());
//        wait.until(driver -> driver.findElement(By.xpath("//div[@id='1370964']//h2[@class='normal'][contains(text(),'Post Office')]")));
        assertThat(getDriver().findElement(By.xpath("//div[@id='locationContainer_1']")).getText().equalsIgnoreCase(address));
    }

    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn( String size, String address ) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> driver.findElement(By.xpath("//div[@id='1370964']//h2[@class='normal'][contains(text(),'Post Office')]")).isDisplayed());
//        getDriver().findElement(By.xpath("//div[@id='1370964']//h2[@class='normal'][contains(text(),'Post Office')]")).click();
        getDriver().findElement(By.xpath("//h2[string()='" + address + "']")).click();
        getDriver().findElements(By.xpath("//div[@class='locationContainer row']"));
        assertThat(getDriver().findElement(By.xpath("//div[@class='locationContainer row']")).getText().contains(size));
        assertThat(getDriver().findElement(By.xpath("//div[@class='locationContainer row']")).getText().contains(address));
    }
}
