import PageObjectModel.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsUserAbleToChangePassword {

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
        userSettingsPage.getChangePasswordForm();
        userSettingsPage.createNewPassword();
    }


    @AfterClass
    public void tearDown(){
        Browser.closeBrowser();
    }
}
