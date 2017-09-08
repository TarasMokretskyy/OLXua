package PageObjectModel;

import TestDate.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends WebPage {


    private Credentials credentials = new Credentials();


    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "userPass")
    private WebElement passwordField;

    @FindBy(id = "se_userLogin")
    private WebElement enterButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getEmailField(){
        return emailField;
    }


    public WebElement getPasswordField(){
        return passwordField;
    }


    public WebElement getEnterButton(){
        return enterButton;
    }

    @Step
    public void enterText(WebElement element, String text){
        WebPage.inputText(element, text);
    }



    @Step
    public UserAccountPage loginIntoTheSystem(){
        enterText(getEmailField(), credentials.getUserEmail());
        enterText(getPasswordField(), credentials.getUserPassword());
        WebPage.click(getEnterButton());
        return new UserAccountPage(Browser.getDriver());
    }
}