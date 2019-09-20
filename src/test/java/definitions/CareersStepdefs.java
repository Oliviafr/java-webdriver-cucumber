package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import support.RestWrapper;

import java.util.List;
import java.util.Map;


import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getData;

public class CareersStepdefs {
    @Given("I login to REST API as {string}")
    public void iLoginToRESTAPIAs( String role ) throws FileNotFoundException {
        //Libraries for REST API
        //Unirest
        //Okhttprequest

        new RestWrapper().logIn(getData(role));
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition( String type ) throws FileNotFoundException {
        new RestWrapper().createPosition(getData(type));
    }


    @Then("I verify via REST API position is created")
    public void iVerifyViaRESTAPIPositionIsCreated() throws InterruptedException {
        List<Map<String, Object>> positions = new RestWrapper().getPositions();
        Map<String, Object> lastPosition = RestWrapper.getLastPosition();

        boolean isFound = false;
        for (Map<String, Object> position : positions) {
            if (position.get("id").equals(lastPosition.get("id"))) {
                isFound = true;

                for (String key : lastPosition.keySet()) {

                    Object expected = lastPosition.get(key);
                    Object actual = position.get(key);
                    assertThat(actual).isEqualTo(expected);

                }
            }
        }
        assertThat(isFound).isTrue();


    }

    @When("I update via REST API {string} position")
    public void iUpdateViaRESTAPIPosition( String title ) throws FileNotFoundException {
//        new RestWrapper().updatePosition(getData(title),);

        List<Map<String, Object>> positions = new RestWrapper().getPositions();
        Map<String, Object> lastPosition = RestWrapper.getLastPosition();

        boolean isFound = false;
        for (Map<String, Object> position : positions) {
            if (position.get("id").equals(lastPosition.get("id"))) {
                System.out.println(position.get("id"));
                new RestWrapper().updatePosition(getData(title),lastPosition.get("id"));
                isFound = true;
            }
        }
        assertThat(isFound).isTrue();
    }

    @Then("I verify via REST API position updated")
    public void iVerifyViaRESTAPIPositionUpdated() throws FileNotFoundException {
        Map<String, Object> lastPosition = RestWrapper.getLastPosition();
        assertThat(lastPosition.get("title").equals(getData("title")));
    }

    @And("I delete via REST API created position")
    public void iDeleteViaRESTAPICreatedPosition() {
        List<Map<String, Object>> positions = new RestWrapper().getPositions();
        Map<String, Object> lastPosition = RestWrapper.getLastPosition();
        new RestWrapper().delete(lastPosition.get("id"));
    }
}
