package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllCategoriesPopUpWindow extends WebPage {


    @FindBy(id = "cat-57")
    private WebElement furnitureCategoty;


    public AllCategoriesPopUpWindow(WebDriver driver) {
        super(driver);
    }


    public WebElement getFurnitureCategoty() {
        return furnitureCategoty;
    }


    public void clickOnWebelement(WebElement element){
        WebPage.click(element);
    }
}