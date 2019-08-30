package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import support.TestContext;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersObjectStepdefs {

    @And("I login as {string}")
    public void iLoginAs( String role ) throws FileNotFoundException {
        new Careers()
                .clickLogin()
                .login(getData(role));

    }

    @Then("I verify {string} login")
    public void iVerifyLogin( String role ) throws FileNotFoundException {
        String actualName = new Careers().getLoggedInUser();
        assertThat(actualName).isEqualTo(getData(role).get("name"));
    }

    @When("I create {string} requisition")
    public void iCreateRequisition( String position ) throws FileNotFoundException, InterruptedException {
        Positions createNew = new Positions();
        createNew.searchPosition(position);
        createNew.createPosition();
        new NewPosition().createPosition(position);
    }

    @And("I verify {string} position created")
    public void iVerifyPositionCreated( String position ) throws FileNotFoundException {
        String actualPosition = new Positions().verifyPosition(position);
        assertThat(actualPosition).contains(getData(position).get("title"));
    }
}
