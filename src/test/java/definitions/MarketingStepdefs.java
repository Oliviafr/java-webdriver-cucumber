package definitions;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import static support.TestContext.getDriver;

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
}
