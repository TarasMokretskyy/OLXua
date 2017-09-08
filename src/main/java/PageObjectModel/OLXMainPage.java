package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class OLXMainPage extends WebPage {

    public static final String OLX_URL = "https://www.olx.ua/uk/";

    private UpperBar upperBar = new UpperBar(Browser.getDriver());


    public OLXMainPage(WebDriver driver) {
        super(driver);
    }


    @Step
    public LoginPage getLoginPage(){
        WebPage.click(upperBar.getMyProfileLink());
        return new LoginPage(Browser.getDriver());
    }
}