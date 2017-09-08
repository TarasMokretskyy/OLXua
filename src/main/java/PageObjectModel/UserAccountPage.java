package PageObjectModel;

import org.openqa.selenium.WebDriver;

public class UserAccountPage extends WebPage {

    private UpperBar upperBar = new UpperBar(Browser.getDriver());


    public UserAccountPage(WebDriver driver) {
        super(driver);
    }


    public AdvertisementPage getAdvertisementPage(){
        WebPage.click(upperBar.getAddAdvertisementButton());
        return new AdvertisementPage(Browser.getDriver());
    }


    public UserSettingsPage getUserSettingsPage(){
        WebPage.pointingToElement(upperBar.getMyProfileLink());
        WebPage.clickOnElementInList(upperBar.getMyProfileList(), 3);
        return new UserSettingsPage(Browser.getDriver());
    }
}