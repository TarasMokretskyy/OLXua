import PageObjectModel.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsUserAbleToChangeContactDetails {

    private Browser browser = new Browser(Browser.getDriver());

    private OLXMainPage olxMainPage;

    private LoginPage loginPage;

    private UserAccountPage userAccountPage;

    private UserSettingsPage userSettingsPage;


    @BeforeClass
    public void setUp(){
        Browser.createBrowserInstance();
        olxMainPage = browser.getOLXMainPage();
    }


    @Test
    public void isUserAbleToCreateAdvertisementTest(){
        loginPage = olxMainPage.getLoginPage();
        userAccountPage = loginPage.loginIntoTheSystem();
        userSettingsPage = userAccountPage.getUserSettingsPage();
        userSettingsPage.getContactDetailsChangeForm();
        userSettingsPage.changeTextInChooseCityField();
        userSettingsPage.changeTextInContactPersonField();
        userSettingsPage.saveChanges();
    }


    @AfterClass
    public void tearDown(){
        Browser.closeBrowser();
    }
}