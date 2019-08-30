package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Positions extends Page {

    @FindBy(xpath = "//input[@id='positionsQuickSearchInput']")
    private WebElement positionsearchtext;

    @FindBy(xpath = "//button[@id='positionsQuickSearchButton']")
    private WebElement positionsearchbutton;

    @FindBy(xpath = "//a[@href='/recruit']/button")
    private WebElement linkRecruit;

    @FindBy(xpath = "//a[@href='/new_position']/h4")
    private WebElement newPosition;

    @FindBy(xpath = "//div[@class='col-sm-12 col-md-4 col-lg-3']")
    private List<WebElement> allFoundPositions;


    public Positions searchPosition( String position ) {
        this.positionsearchtext.sendKeys(position);
        this.positionsearchbutton.click();
        return this;
    }

    public Positions createPosition() {
        this.linkRecruit.click();
        this.newPosition.click();
        return this;
    }

    public String verifyPosition( String positon ) {
        int index = 0;
        for (int i = 0; i < allFoundPositions.size(); i++) {
            if (allFoundPositions.get(i).getText().contains(positon)) {
                index = i;
            }
        }
        return allFoundPositions.get(index).getText();
    }

    public void deletePosition() {

    }
}
