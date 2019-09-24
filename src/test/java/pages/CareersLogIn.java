package pages;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static support.TestContext.getDriver;

public class CareersLogIn extends Page {
    @FindBy(xpath="//label[@for='loginUsername']/../input")
    private WebElement username;

    @FindBy(xpath="//label[@for='loginPassword']/../input")
    private WebElement password;

    @FindBy(xpath="//button[@id='loginButton']")
    private WebElement submit;

    public CareersLogIn fillUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public CareersLogIn fillPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public Careers clickSubmit() {
        click(submit);
//        submit.click();
        return new Careers();
    }

    private Careers login( String username, String password ) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.elementToBeClickable(submit));
        click(submit);
//        submit.click();
        return new Careers();
    }

    public Careers login(Map<String, String> user) {
        return login(user.get("username"), user.get("password"));
    }
}
