package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class CalculatorMyStepdefs {
    @When("I navigate to {string}")
    public void iNavigateTo( String tab ) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + tab + "']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {

    }
}
