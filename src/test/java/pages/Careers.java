package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Careers extends Page {
    public Careers() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedInUser;


    @FindBy(xpath = "//a[@href='/new_candidate']/button")
    private WebElement apply;


    public CareersLogIn clickLogin() {
        loginButton.click();
        return new CareersLogIn();
    }

    public String getLoggedInUser() {
        return loggedInUser.getText();
    }

    public NewCandidate clickApply() {
        apply.click();
        return new NewCandidate();
    }


}
