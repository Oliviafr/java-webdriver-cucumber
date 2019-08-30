package definitions;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class ConverterStepdefs {


}

//    public ConverterStepdefs() {
//        When("^I click on \"([^\"]*)\"$", ( String tempr ) -> {
//            getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'" + tempr + "')]")).click();
//        });
//        And("^I set \"([^\"]*)\" to \"([^\"]*)\"$", ( String from, String to ) -> {
//            getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'" + from + "')]")).click();
//            getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'" + to + "')]")).click();
//        });
//        Then("^I enter into From Field \"([^\"]*)\" and verify \"([^\"]*)\" result$", ( String from, String to ) -> {
//            getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(from);
////            getDriver().findElement(By.xpath("//input[@name='toVal']")).isDisplayed();
//            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//            wait.until(driver -> driver.findElement(By.xpath("//input[@name='toVal']")).getText().contains(to));
//        });
//
//    }