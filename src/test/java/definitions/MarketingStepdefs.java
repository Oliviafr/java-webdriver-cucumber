package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.transform.Undefined;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class MarketingStepdefs {
    @Given("I open quote page")
    public void iOpenQuotePage() {
        getDriver().get("https://skryabin.com/market/quote.html");
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getPageSource());
    }

    @And("I print page title")
    public void iPrintPageTitle() {
        System.out.println(getDriver().getTitle());
    }

    @And("I print window handles")
    public void iPrintWindowHandles() {
        System.out.println(getDriver().getWindowHandles());
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Ötto");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@dddd.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("123412345");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("123412345");
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        try {
            Thread.sleep(0b1111101000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ötto");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("Greg");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kochler");
        getDriver().findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[1]")).click();
        getDriver().findElement(By.xpath("//input[@name='phone'][@type='number']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='phone'][@type='number']")).sendKeys("1113338888");
        getDriver().findElement(By.xpath("//*[contains(text(),'Monaco')]")).click();

        try {
            Thread.sleep(0b1111101000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//*[@name='gender'][@value='female']")).click();
        getDriver().findElement(By.xpath("//*[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys("Graben 28 Suite 1a2b3c");
        getDriver().findElement(By.xpath("//*[contains(text(),'Toyota')]")).click();
        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//label[contains(text(),'Date of Birth')]")).click();
        try {
            Thread.sleep(0b1111101000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getDriver().findElement(By.xpath("//div[@id='ui-datepicker-div']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']/option[11]")).click();
            getDriver().findElement(By.xpath("//select[@data-handler='selectYear']/option[@value='1981']")).click();
            getDriver().findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='17']")).click();

        } else {
            try {
                Thread.sleep(0b1111101000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        WebElement privacy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
//        getExecutor().executeScript("arguments[0].click;", privacy);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the info in the form")
    public void iVerifyTheInfoInTheForm() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        assertThat(result).containsIgnoringCase("Ötto");
        boolean firstname = getDriver().findElement(By.xpath("//b[@name='firstName'][contains(text(),'Ötto')]")).isDisplayed();
        boolean username = getDriver().findElement(By.xpath("//b[@name='username'][contains(text(),'Ötto')]")).isDisplayed();
        boolean name = getDriver().findElement(By.xpath("//b[@name='name'][contains(text(),'Ötto Greg Kochler')]")).isDisplayed();
        boolean countryOfOrigin = getDriver().findElement(By.xpath("//b[@name='countryOfOrigin'][contains(text(),'Monaco')]")).isDisplayed();
        boolean carMake = getDriver().findElement(By.xpath("//b[@name='carMake'][contains(text(),'Toyota')]")).isDisplayed();
        boolean email = getDriver().findElement(By.xpath("//b[@name='email'][contains(text(),'test@dddd.com')]")).isDisplayed();
        boolean phone = getDriver().findElement(By.xpath("//b[@name='phone'][contains(text(),'1113338888')]")).isDisplayed();
        boolean gender = getDriver().findElement(By.xpath("//b[@name='gender'][contains(text(),'female')]")).isDisplayed();
        boolean agreedToPrivacyPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy'][contains(text(),'true')]")).isDisplayed();
        boolean password = getDriver().findElement(By.xpath("//b[@name='password'][contains(text(),'[entered]')]")).isDisplayed();
        boolean dateOfBirth = getDriver().findElement(By.xpath("//b[@name='dateOfBirth'][contains(text(),'11/17/1981')]")).isDisplayed();
        boolean allowedToContact = getDriver().findElement(By.xpath("//b[@name='allowedToContact'][contains(text(),'true')]")).isDisplayed();
        boolean location = getDriver().findElement(By.xpath("//b[@name='location'][contains(text(),'Los Altos, CA 94022')]")).isDisplayed();
        boolean thirdPartyAgreement = getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement'][contains(text(),'accepted')]")).isDisplayed();
        ContainTextFromFunction("//b[@name='currentDate']");

        if (firstname && username && name && countryOfOrigin && carMake && email && phone && gender && agreedToPrivacyPolicy && password && dateOfBirth && allowedToContact && location && thirdPartyAgreement) {
            System.out.println("correct!");
        } else {
            System.out.println("not correct!");
        }

    }

    @Given("I go to {string} page")
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
            default:
                throw new RuntimeException("Unsupported page: " + page);

        }
    }


    @Then("I go back and forward,then refresh the page {string}")
    public void iGoBackAndForwardThenRefreshThePage( String page ) {

        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                getDriver().navigate().back();
                getDriver().navigate().forward();
                break;
            case "google":
                getDriver().get("https://www.google.com");
                getDriver().navigate().back();
                getDriver().navigate().forward();
                break;
            default:
                throw new RuntimeException("Unsupported page: " + page);
        }
        getDriver().navigate().refresh();
    }


    @Then("I go back and forward,then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
//        getDriver().get("https://skryabin.com/market/quote.html");
//        getDriver().get("https://www.google.com");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Then("I change resolution to phone")
    public void iChangeResolutionToPhone() throws InterruptedException {
        Dimension dimension = new Dimension(400, 768);
        getDriver().manage().window().setSize(dimension);
        Thread.sleep(3000);
    }

    @Then("I change resolution to desktop")
    public void iChangeResolutionToDesktop() throws InterruptedException {
        Dimension dimension = new Dimension(1024, 768);
        getDriver().manage().window().setSize(dimension);
        Thread.sleep(3000);
    }

    @Then("I verify the info with assert")
    public void iVerifyTheIfoWithAssert() {
        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        assertThat(result).containsIgnoringCase("Ötto");

        assertThat(getDriver().findElement(By.xpath("//b[@name='username'][contains(text(),'Ötto')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName'][contains(text(),'Kochler')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='email'][contains(text(),'test@dddd.com')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake'][contains(text(),'Toyota')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='location'][contains(text(),'Los Altos, CA 94022')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName'][contains(text(),'Ötto')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='name'][contains(text(),'Ötto Greg Kochler')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='gender'][contains(text(),'female')]")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//b[@name='gender'][contains(text(),'female')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin'][contains(text(),'Monaco')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy'][contains(text(),'true')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText().contains("true"));
        ContainTextFromFunction("//b[@name='currentDate']");
        assertThat(getDriver().findElement(By.xpath("//b[@name='middleName'][contains(text(),'Greg')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText().contains("1113338888"));
        assertThat(getDriver().findElement(By.xpath("//b[@name='allowedToContact'][contains(text(),'true')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth'][contains(text(),'11/17/1981')]")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//b[@name='password'][contains(text(),'[entered]')]")).isDisplayed());
        ContainTextFromFunctionTime("//b[@name='currentTime']");

        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement'][contains(text(),'accepted')]")).isDisplayed());
    }

    private void ContainTextFromFunctionTime( String xpath ) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println(actualText);
        Time_custom time = new Time_custom();
        System.out.println(time.TimeNow(actualText));
    }

    private void ContainTextFromFunction( String xpath ) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        Date_custom date = new Date_custom();
        String date_format;
        date_format = date.TheDateOf("");
        System.out.println(date_format);
        assertThat(actualText).contains(date_format);
//        System.out.println(assertThat(actualText).contains(date_format));
    }
}


