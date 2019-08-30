package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.runners.model.TestTimedOutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsSignIn extends Page {

    @FindBy(xpath = "//button[@id='btn-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@id='sign-up-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//span[@id='error-username']")
    private WebElement usernameError;

    public boolean isSignUpPossible() {
        return signUpButton.isDisplayed() && signUpButton.isEnabled();
    }

    public boolean isSignInRequired() throws InterruptedException, TimeoutException {
        signInButton.click();
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.visibilityOf(usernameError));
//        Thread.sleep(3000);
        return true;
    }

}
