package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;

public class ConvertersStepdefs {
    @When("I click on {string}")
    public void iClickOn(String tab) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + tab + "']")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String from, String to) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']/option[text()='" + from + "']")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']/option[text()='" + to + "']")).click();
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String fromValue, String toValue) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(fromValue);
        String result = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(result).contains(toValue);
    }
}

