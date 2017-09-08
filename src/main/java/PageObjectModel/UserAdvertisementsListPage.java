package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAdvertisementsListPage extends WebPage {

    @FindBy(css = "*[href='https://www.olx.ua/uk/myaccount/waiting/']")
    private WebElement expectingLink;

    @FindBy(css = "*[id='typearchive'] > a")
    private WebElement inactiveLink;

    @FindBy(css = "*[class^='tdnone nowrap abs'] *[class='link reporthov']")
    private WebElement removePublicationLink;

    @FindBy(css = "*[class='link reporthov']")
    private WebElement deleteLink;


    public UserAdvertisementsListPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getDeleteLink() {
        return deleteLink;
    }

    public WebElement getRemovePublicationLink() {
        return removePublicationLink;
    }


    public WebElement getInactiveLink() {
        return inactiveLink;
    }


    public WebElement getExpectingLink() {
        return expectingLink;
    }


    public void clickOnExpectingLink(WebElement element){
        WebPage.click(element);
    }


    public void clickOnInactiveLink(WebElement element){
        WebPage.click(element);
    }


    public void clickOnRemovePublicatinLink(WebElement element){
        WebPage.click(element);
    }


    public void clickOnDeleteLink(WebElement element){
        WebPage.click(element);
    }


    public UserAdvertisementsListPage deletingNewAdvertisement(){
        clickOnExpectingLink(getExpectingLink());
        clickOnRemovePublicatinLink(getRemovePublicationLink());
        clickOnInactiveLink(getInactiveLink());
        clickOnDeleteLink(getDeleteLink());
        return new UserAdvertisementsListPage(Browser.getDriver());
    }
}