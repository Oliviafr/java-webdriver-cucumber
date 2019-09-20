package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static support.TestContext.getData;

public class NewCandidate extends Page {

    @FindBy(xpath = "//label[@for='candidateFirstName']/../input")
    private WebElement candidateFirstName;

    @FindBy(xpath = "//label[@for='candidateMiddleName']/../input")
    private WebElement candidateMiddleName;

    @FindBy(xpath = "//label[@for='candidateLastName']/../input")
    private WebElement candidateLastName;

    @FindBy(xpath = "//label[@for='candidateEmail']/../input")
    private WebElement candidateEmail;

    @FindBy(xpath = "//label[@for='candidatePassword']/../input")
    private WebElement candidatePassword;

    @FindBy(xpath = "//label[@for='candidateConfirmPassword']/../input")
    private WebElement candidateConfirmPassword;

    @FindBy(xpath = "//label[@for='candidateSummary']/../textarea")
    private WebElement candidateSummary;

    @FindBy(xpath = "//label[@for='candidateState']/../select/option[3]")
    private WebElement stateAlaska;

    @FindBy(xpath = "//label[@for='candidateAddress']/../input")
    private WebElement candidateAddress;

    @FindBy(xpath = "//label[@for='candidateCity']/../input")
    private WebElement candidateCity;

    @FindBy(xpath = "//label[@for='candidateZip']/../input")
    private WebElement candidateZip;

    @FindBy(xpath = "//button[@id='candidateSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class='mr-2 text-white text-decoration-none']")
    private WebElement profile;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement deleteProfile;



    public NewCandidate createCandidate( String candidate ) throws FileNotFoundException {
        this.candidateFirstName.sendKeys(getData(candidate).get("first_name"));
        this.candidateMiddleName.sendKeys(getData(candidate).get("middle_Name"));
        this.candidateLastName.sendKeys(getData(candidate).get("last_name"));
        this.candidateEmail.sendKeys(getData(candidate).get("email"));
        this.candidatePassword.sendKeys(getData(candidate).get("password"));
        this.candidateConfirmPassword.sendKeys(getData(candidate).get("confirm_Password"));
        this.candidateSummary.sendKeys(getData(candidate).get("summary"));
        this.candidateAddress.sendKeys(getData(candidate).get("address"));
        this.candidateCity.sendKeys(getData(candidate).get("city"));
        this.candidateZip.sendKeys(getData(candidate).get("zip"));
        stateAlaska.click();
        submitButton.click();
        return new NewCandidate();
    }

    public void deleteCandidate() {
        profile.click();
        deleteProfile.click();
    }

}
