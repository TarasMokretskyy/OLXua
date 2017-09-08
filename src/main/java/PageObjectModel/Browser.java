package PageObjectModel;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class Browser {

    protected static WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }


    @Step
    public static void createBrowserInstance() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Step
    public OLXMainPage getOLXMainPage() {
        driver.get(OLXMainPage.OLX_URL);
        return new OLXMainPage(Browser.getDriver());
    }


    public static WebDriver getDriver() {
        return driver;
    }



    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}