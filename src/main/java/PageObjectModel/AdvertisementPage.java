package PageObjectModel;

import TestDate.AdvertisementOptions;
import TestDate.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AdvertisementPage extends WebPage {

    private AdvertisementOptions advertisementOptions = new AdvertisementOptions();

    private Credentials credentials = new Credentials();

    private AllCategoriesPopUpWindow allCategoriesPopUpWindow = new AllCategoriesPopUpWindow(Browser.getDriver());


    @FindBy(id = "add-title")
    private WebElement titleField;

    @FindBy(css = "*[id='targetrenderSelect1-0'] *[href='#']")
    private WebElement rubricField;

    @FindBy(id = "add-description")
    private WebElement descriptionField;

    @FindBy(id = "add-phone")
    private WebElement mobileNumberField;

    @FindBy(css = "*[class^='text x-normal br3']")
    private WebElement priceField;

    @FindBy(id = "save")
    private WebElement furtherButton;

    @FindBy(id = "targetparam47")
    private WebElement furnitureTypeDropDown;

    @FindBy(css = "ul[style='display: block;'] li")
    private List<WebElement> furtherTypeList;

    @FindBy(id = "targetparam13")
    private WebElement stateDropDown;

    @FindBy(css = "*#targetparam13 ul[style='display: block;'] li")
    private List<WebElement> stateList;

    @FindBy(id = "targetid_private_business")
    private WebElement ownerOrBusinessDropDown;

    @FindBy(css = "*#targetid_private_business ul[style='display: block;'] li")
    private List<WebElement> ownerOrBusinessList;


    public AdvertisementPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getStateList() {
        return stateList;
    }


    public List<WebElement> getOwnerOrBusinessList() {
        return ownerOrBusinessList;
    }


    public List<WebElement> getFurtherTypeList() {
        return furtherTypeList;
    }


    public WebElement getOwnerOrBusinessDropDown() {
        return ownerOrBusinessDropDown;
    }


    public WebElement getStateDropDown() {
        return stateDropDown;
    }


    public WebElement getFurnitureTypeDropDown() {
        return furnitureTypeDropDown;
    }


    public WebElement getPriceField() {
        return priceField;
    }


    public WebElement getTitleField() {
        return titleField;
    }


    public WebElement getRubricField() {
        return rubricField;
    }


    public WebElement getDescriptionField() {
        return descriptionField;
    }


    public WebElement getMobileNumberField() {
        return mobileNumberField;
    }


    public WebElement getFurtherButton() {
        return furtherButton;
    }


    @Step
    public AdvertisementResult addNewAdvertisement(){
        WebPage.inputText(getTitleField(), advertisementOptions.getAdvertisementName());
        WebPage.click(getRubricField());
        WebPage.click(allCategoriesPopUpWindow.getFurnitureCategoty());
        WebPage.inputText(getPriceField(), advertisementOptions.getAdvertisementPrice());
        WebPage.click(getFurnitureTypeDropDown());
        WebPage.clickOnElementInList(getFurtherTypeList(), 1);
        WebPage.click(getStateDropDown());
        WebPage.clickOnElementInList(getStateList(), 2);
        WebPage.click(getOwnerOrBusinessDropDown());
        WebPage.clickOnElementInList(getOwnerOrBusinessList(), 1);
        WebPage.inputText(getDescriptionField(), advertisementOptions.getAdvertisementDescription());
        WebPage.inputText(getMobileNumberField(), credentials.getUserPhoneNumber());
        WebPage.click(getFurtherButton());
        return new AdvertisementResult(Browser.getDriver());
    }
}