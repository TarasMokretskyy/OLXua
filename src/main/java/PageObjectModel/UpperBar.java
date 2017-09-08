package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpperBar extends WebPage {

    @FindBy(css = "*[class='link inlblk']>*")
    private WebElement myProfileLink;

    @FindBy(css = "*[id='userLoginBox'] ul:nth-of-type(1) li")
    private List<WebElement> myProfileList;

    @FindBy(id = "postNewAdLink")
    private WebElement addAdvertisementButton;


    public UpperBar(WebDriver driver) {
        super(driver);
    }


    public WebElement getAddAdvertisementButton() {
        return addAdvertisementButton;
    }


    public void clickOnElementInCollection(List<WebElement> element, int index){
        WebPage.clickOnElementInList(element, index);
    }


    public List<WebElement> getMyProfileList() {
        return myProfileList;
    }


    public WebElement getMyProfileLink() {
        return myProfileLink;
    }


    public void getUserMenu(WebElement element){
        WebPage.pointingToElement(element);
    }
}