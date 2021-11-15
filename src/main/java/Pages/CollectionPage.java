package Pages;

import Services.CommonServices;
import Utils.UtilConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CollectionPage extends CommonServices {
    /*--------Collection Page ---------*/
    @FindBy(css="h1[class=\"heading-1 page-header-heading\"]")
    public WebElement pageHeader;
    @FindBy(css="input[class=\"collection-search-input\"]")
    public WebElement searchInput;
    @FindBy(css="button[class=\"link link-icon-right link-icon-no-animation list-filters-form-filter-button\"]")
    public WebElement filterBtn;
    @FindBy(css="span[class=\"results\"]")
    public WebElement result;
    @FindBy(css="button svg[class=\"icon-search\"]")
    public WebElement searchIcon;
    @FindBy(css="picture img[alt=\"Vincent van Gogh, Het Gele Huis (De straat), 1888\"]")
    public WebElement firstSearchedResult;

    /*-- Picture:More information section */
    @FindBy(css="button[aria-label=\"Open Objectgegevens\"]")
    public WebElement ObjectgegevensLnk;

    @FindBy(css="div dt[class='definition-list-item-label']")
    public List<WebElement> fieldLabels;
    @FindBy(css="div dd[class='definition-list-item-value']")
    public List<WebElement> fieldValues;

    public CollectionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, data.getShortWait()), this);
    }
    public String getHeader(){
        return pageHeader.getText();
    }

    public void navigateToCollectionPg(WebElement element,SoftAssert soft) throws InterruptedException {
        horizontalScroll(element);

        soft.assertTrue(element.isDisplayed(),"Element is shown");
        soft.assertTrue(element.getText().equals(UtilConstants.COLLECTIE_PAGE_LINK),"Correct link is present");
        element.click();
        smallWait();
    }
    public String getFieldValue(String listName, SoftAssert soft){

        if(listName.equals(UtilConstants.F_NUMMER_FIELD_LABEL)){
            log.info("Field label is :"+ fieldLabels.get(0),"Field label is 'F-nummer'");
            return fieldValues.get(0).getText();

        }
        if(listName.equals(UtilConstants.JH_NUMMER_FIELD_LABEL)){
            log.info("Field Label is :"+ fieldLabels.get(1),"Field label is 'JH-nummer'");
            return fieldValues.get(1).getText();

        }
        if(listName.equals(UtilConstants.INVENTARISNUMMER_FIELD_LABEL)){
            log.info("Field label is:"+ fieldLabels.get(2),"Field label is 'Inventarisnummer'");
            return fieldValues.get(2).getText();

        }
        return " ";
    }
}
