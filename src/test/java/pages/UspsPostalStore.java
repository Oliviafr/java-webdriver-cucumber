package pages;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsPostalStore extends Page {

    @FindBy(xpath = "//select[@id='Ns']")
    private WebElement sortBy;

    @FindBy(xpath = "(//div[@class='results-product-info'])[1]")
    private WebElement firstFoundItem;


    @FindBy(xpath = "//div[@class='results-product-info']")
    private List<WebElement> allFoundItems;

    @FindBy(xpath = "//label[contains(text(),'$0 to $5 (75)')]")
    private WebElement priceRange;



    public void selectSortBy( String text ) {
        new Select(sortBy).selectByVisibleText(text);
    }

    public String getFirstFoundItem() {
        return firstFoundItem.getText();
    }

    public String getFoundItem(String str ) {
//        return allFoundItems.get(index).getText();
        int index = 0;
        for (int i = 0; i < allFoundItems.size(); i++) {
            if (allFoundItems.get(i).getText().contains(str)) {
                index = i;
            }
//            By priceSelector = By.xpath("//div[class='results-product-preview-price']");
//            String itemPrice = allFoundItems.get(i).getText();
            //deal with currency
            Locale locale = new Locale("en","US");
            NumberFormat formatter = NumberFormat.getNumberInstance(locale);
//            double itemPrice = formatter.parse(itemPrice).doubleValue();
        }return allFoundItems.get(index).getText();
    }

    public void checkPrice() {
        priceRange.click();
    }

}