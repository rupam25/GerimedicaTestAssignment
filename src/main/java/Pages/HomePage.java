package Pages;

import Services.CommonServices;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage extends CommonServices {
    /* ---------- Default Page elements------------ */
    @FindBy(css = "div button[class='cookie-banner-button btn']")
    public WebElement accordBtn;
    @FindBy(css="article[class=\"card-overview-content-end\"] a[class='link link-icon-left']")
    public List<WebElement> links;
    @FindBy(css="heading-2 card-overview-content-start-heading")
    public WebElement pageHeader;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, data.getShortWait()), this);
    }

}
