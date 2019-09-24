package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static support.TestContext.getDriver;

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

    @FindBy(xpath = "//li[@class='list-item card list ']")
    private List<WebElement> allFoundPositionsForCandidate;

    @FindBy(xpath = "//li[@id='2']//i[@class='fa fa-check']")
    private WebElement position2;



    //li[@class='list-item card list ']
    public Positions searchPosition( String position ) throws InterruptedException {
        Thread.sleep(3000);
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
        new WebDriverWait(getDriver(),10).until(webDriver -> allFoundPositions.size() > 2);
        int index = 0;
        for (int i = 0; i < allFoundPositions.size(); i++) {
            if (allFoundPositions.get(i).getText().toLowerCase().contains(positon)) {
                index = i;
            }
        }
        return allFoundPositions.get(index).getText();
    }

    public Position clickOnPosition( String positon ) {
        new WebDriverWait(getDriver(),10).until(webDriver -> allFoundPositionsForCandidate.size() > 2);
        int index = 1;
//        for (int i = 0; i < allFoundPositionsForCandidate.size(); i++) {
//
////            if (allFoundPositionsForCandidate.get(i).getText().toLowerCase().contains(positon)) {
////                index = i;
////            }
//        }
        click(allFoundPositionsForCandidate.get(index));
//        allFoundPositionsForCandidate.get(index).click();
//        position2.click();
        return new Position();

    }





    public void deletePosition() {

    }
}
