package PageObjectModel;

import org.openqa.selenium.WebDriver;

public class AdvertisementResult extends WebPage {

    private UpperBar upperBar = new UpperBar(Browser.getDriver());


    public AdvertisementResult(WebDriver driver) {
        super(driver);
    }


    public void getUserMenu(){
        upperBar.getUserMenu(upperBar.getMyProfileLink());
    }


    public UserAdvertisementsListPage getAdvertisementDetailsPage(){
        upperBar.clickOnElementInCollection(upperBar.getMyProfileList(), 0);
        return new UserAdvertisementsListPage(Browser.getDriver());
    }
}