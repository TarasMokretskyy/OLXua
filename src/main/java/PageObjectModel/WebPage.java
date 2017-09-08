package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class WebPage extends Browser {


    public WebPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(Browser.getDriver(), this);
    }


    public static void click(WebElement element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitForElementsList(List<WebElement> element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }


    public static void inputText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element));
        elem.clear();
        elem.sendKeys(text);
    }


    public static void clickOnElementInList(List<WebElement> element, int index){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(element.get(index)));
        elem.click();
    }


    public static void pointingToElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).build().perform();
    }
}