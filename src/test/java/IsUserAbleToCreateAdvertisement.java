import PageObjectModel.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsUserAbleToCreateAdvertisement {

    private Browser browser = new Browser(Browser.getDriver());

    private OLXMainPage olxMainPage;

    private LoginPage loginPage;

    private UserAccountPage userAccount;

    private AdvertisementPage advertisementPage;

    private AdvertisementResult advertisementResult;

    private UserAdvertisementsListPage userAdvertisementsListPage;


    @BeforeClass
    public void setUp(){
        Browser.createBrowserInstance();
        olxMainPage = browser.getOLXMainPage();
    }


    @Test
    public void isUserAbleToCreateAdvertisementTest(){
        loginPage = olxMainPage.getLoginPage();
        userAccount = loginPage.loginIntoTheSystem();
        advertisementPage = userAccount.getAdvertisementPage();
        advertisementResult = advertisementPage.addNewAdvertisement();
    }


    @AfterClass
    public void tearDown(){
        advertisementResult.getUserMenu();
        userAdvertisementsListPage = advertisementResult.getAdvertisementDetailsPage();
        userAdvertisementsListPage.deletingNewAdvertisement();
        Browser.closeBrowser();
    }
}