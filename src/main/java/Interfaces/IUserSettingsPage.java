package Interfaces;

import PageObjectModel.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public interface IUserSettingsPage {

    void pointingToElement(List<WebElement> element, int index);

    void waitForElementsListDisappearing(List<WebElement> element);
}
