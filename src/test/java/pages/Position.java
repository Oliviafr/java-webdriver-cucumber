package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Position extends Page {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement applyPosition;

    public Positions clickOnApply (){
        applyPosition.click();
        return new Positions();
    }
}
