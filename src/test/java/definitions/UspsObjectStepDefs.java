package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Usps;
import pages.UspsPostalStore;
import pages.UspsSignIn;
import pages.UspsTracking;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsObjectStepDefs {
    @When("I go to {string} oop")
    public void iGoToOop( String buttonType ) {
        switch (buttonType) {
            case "stamps":
                new Usps().clickStamps();
                break;
            case "boxes":
                new Usps().clickBoxes();
                break;
            case "labels":
                new Usps().clickLabels();
                break;
            case "tracking":
                new Usps().clickTracking();
                break;
            default:
                throw new RuntimeException("Unrecognized buttonType: " + buttonType);
        }

    }

    @And("I sort by {string} oop")
    public void iSortByOop( String text ) throws InterruptedException {
        Thread.sleep(2000);
        new UspsPostalStore().selectSortBy(text);
        Thread.sleep(2000);
    }

    @Then("I verify that {string} is cheapest oop")
    public void iVerifyThatIsCheapestOop( String expected ) throws InterruptedException {
        switch (expected) {
            case "Tiffany Lamp":
                String actualItem = new UspsPostalStore().getFirstFoundItem();
                System.out.println("Actual: " + actualItem);
                System.out.println("Expected: " + expected);
                assertThat(actualItem).contains(expected);
                Thread.sleep(2000);
                break;
            case "Priority Mail Express Sticker":
                String actualItem_2 = new UspsPostalStore().getFoundItem(expected);
                System.out.println("Actual: " + actualItem_2);
                System.out.println("Expected: " + expected);
                assertThat(actualItem_2).contains(expected);
                Thread.sleep(2000);
                break;

        }
    }
    @And("I verify section {string} exists oop")
    public void iVerifySectionExistsOop( String selectPrice ) throws InterruptedException {
        Thread.sleep(4000);
        new UspsPostalStore().checkPrice();
    }


    @When("I go to {string} menu oop")
    public void iGoToMenuOop( String postalStore ) {
//            new Usps().mhoverpostalStore();
        new Usps().clickMenuItem(postalStore);

    }


    @Then("I verify that {string} is required oop")
    public void iVerifyThatIsRequiredOop( String action ) throws InterruptedException, TimeoutException {
        boolean isRequired = new UspsSignIn().isSignInRequired();
        assertThat(isRequired).isTrue();
    }

    @Then("I verify that {string} is possible oop")
    public void iVerifyThatIsPossibleOop( String action ) {
//        https://tools.usps.com/go/TrackConfirmAction
//        https://reg.usps.com/entreg/LoginAction_input
        String url= getDriver().getCurrentUrl();
        if (url.contains("Login")){
            assertThat(new UspsSignIn().isSignUpPossible()).isTrue();
        }else if (url.contains("Track")){
            assertThat(new UspsTracking().isSignUpPossible()).isTrue();
        }
    }
}
