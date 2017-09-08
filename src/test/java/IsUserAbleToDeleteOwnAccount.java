import PageObjectModel.*;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsUserAbleToDeleteOwnAccount {
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
        userSettingsPage.getDeleteAccountForm();

        String actualColor = userSettingsPage.getColorOfElement();
        String expectedColor = "#b70303";

        boolean isDeleteButtonPresentsOnThePage = userSettingsPage.getDeleteAccountButton().isDisplayed();

        Assert.assertEquals(actualColor, expectedColor);

        Assert.assertTrue(isDeleteButtonPresentsOnThePage,"Delete button doesn't present on the page");
    }


    @AfterClass
    public void tearDown(){
        Browser.closeBrowser();
    }
}