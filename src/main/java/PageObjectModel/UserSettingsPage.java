package PageObjectModel;

import Interfaces.IUserSettingsPage;
import TestDate.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class UserSettingsPage extends WebPage implements IUserSettingsPage {

    private Credentials credentials = new Credentials();

    @FindBy(css = "*#autosuggest-geo-ul li")
    private List<WebElement> chooseCityList;

    @FindBy(id = "se_changeDefault")
    private WebElement changeContactDetailsLink;

    @FindBy(id = "se_changePassword")
    private WebElement changePasswordLink;

    @FindBy(id = "geoCity")
    private WebElement chooseCityField;

    @FindBy(id = "defaultPerson")
    private WebElement contactPersonField;

    @FindBy(id = "se_chPassword")
    private WebElement newPasswordField;

    @FindBy(id = "se_chRepeatPassword")
    private WebElement repeatNewPasswordField;

    @FindBy(id = "submitDefault")
    private WebElement saveButton;

    @FindBy(id = "passwordInput")
    private WebElement changePasswordButton;

    @FindBy(id = "se_deleteAccount")
    private WebElement deleteAccountLink;

    @FindBy(id = "deleteAccount")
    private WebElement deleteAccountButton;


    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getChooseCityList() {
        return chooseCityList;
    }


    public WebElement getChangePasswordButton() {
        return changePasswordButton;
    }


    public WebElement getNewPasswordField() {
        return newPasswordField;
    }


    public WebElement getRepeatNewPasswordField() {
        return repeatNewPasswordField;
    }


    public WebElement getChangePasswordLink() {
        return changePasswordLink;
    }


    public WebElement getChooseCityField() {
        return chooseCityField;
    }


    public WebElement getContactPersonField() {
        return contactPersonField;
    }


    public WebElement getSaveButton() {
        return saveButton;
    }


    public WebElement getChangeContactDetailsLink() {
        return changeContactDetailsLink;
    }


    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public String getColorOfElement(){
        String color = getDeleteAccountButton().getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }


    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }


    @Step
    public void getContactDetailsChangeForm(){
        WebPage.click(getChangeContactDetailsLink());
    }


    @Step
    public void getChangePasswordForm(){
        WebPage.click(getChangePasswordLink());
    }


    @Step
    public void getDeleteAccountForm(){
        WebPage.click(getDeleteAccountLink());
        WebPage.waitForElement(getDeleteAccountButton());
    }


    @Step
    public UserSettingsPage createNewPassword(){
        WebPage.inputText(getNewPasswordField(), credentials.generateNewUserPassword());
        WebPage.inputText(getRepeatNewPasswordField(), credentials.generateNewUserPassword());
        WebPage.click(getChangePasswordButton());
        return new UserSettingsPage(Browser.getDriver());
    }


    @Step
    public void saveChanges(){
        WebPage.click(getSaveButton());
    }


    @Step
    public void changeTextInChooseCityField(){
        int randomIndex = (int) (Math.random() * 10);
        WebPage.waitForElement(getChooseCityField());
        WebPage.inputText(getChooseCityField(), "Львів");
        WebPage.waitForElementsList(getChooseCityList());
        pointingToElement(getChooseCityList(), randomIndex);
    }


    @Step
    public void changeTextInContactPersonField(){
        waitForElementsListDisappearing(getChooseCityList());
        getContactPersonField().clear();
        WebPage.inputText(getContactPersonField(), credentials.getNewUserName());
    }


    @Override
    public void pointingToElement(List<WebElement> element, int index)
    {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element.get(index)));
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element.get(index)).build().perform();
        element.get(index).click();
        element.get(index).click();
    }


    @Override
    public void waitForElementsListDisappearing(List<WebElement> element){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}