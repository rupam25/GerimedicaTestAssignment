package FunctionalTest;

import Pages.CollectionPage;
import Services.BaseServices;
import Pages.HomePage;
import Utils.UtilConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TestScripts extends BaseServices {
    WebDriver driver;
    final Logger log = LoggerFactory.getLogger(TestScripts.class);


    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod()  {
        log.info("Launching browser");
        driver = getDriver(data.getRunBrowser());
        driver.get(data.getUiBaseUrl());
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() throws Exception {
        log.info("closing browser");
        driver.quit();
    }

    /**
     * TC-1
     * Open Collection page and validate all default elements present on page.
     */
    @Test(description = "TC-1")
    public void navigateToCollectionPage() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        homePage.accordBtn.click();

        WebElement ontdekdeCollectieLnk =homePage.links.get(0);
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.navigateToCollectionPg(ontdekdeCollectieLnk,soft);

        soft.assertTrue(collectionPage.getHeader().equals(UtilConstants.COLLECTION_PAGE_HEADER),"Correct page header is shown");
        soft.assertTrue(collectionPage.searchInput.isDisplayed(),"Search input is displayed");
        soft.assertTrue(collectionPage.filterBtn.isDisplayed(),"Filter button is present");
        soft.assertTrue(Integer.parseInt(collectionPage.result.getText()) == UtilConstants.SEARCH_RESULT_COUNT,"4471 Result count is shown");


        soft.assertAll();
    }
    /**
     * TC-2
     * Search "Het Gele Huis" and verify result count
     */
    @Test(description = "TC-2")
    public void performSearch() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        homePage.accordBtn.click();
        WebElement ontdekdeCollectieLnk = homePage.links.get(0);

        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.navigateToCollectionPg(ontdekdeCollectieLnk,soft);


        collectionPage.fillData(UtilConstants.SEARCH_INPUT,collectionPage.searchInput);

        soft.assertTrue(Integer.parseInt(collectionPage.result.getText())>UtilConstants.SPECIFIC_SEARCH_RESULT_COUNT, "Result count is more than 700");

        soft.assertAll();


    }
    /**
     * TC-3
     * Verify data of first search result
     */
    @Test(description = "TC-3")
    public void verifyDataofFirstSearchResult() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        homePage.accordBtn.click();
        WebElement ontdekdeCollectieLnk = homePage.links.get(0);

        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.navigateToCollectionPg(ontdekdeCollectieLnk,soft);

        collectionPage.firstSearchedResult.click();
        collectionPage.verticalScroll();
        collectionPage.ObjectgegevensLnk.click();
        soft.assertTrue(collectionPage.getFieldValue(UtilConstants.F_NUMMER_FIELD_LABEL,soft).equals(UtilConstants.F_NUMMER_FIELD_VALUE),"Shown value is F0464 ");
        soft.assertTrue(collectionPage.getFieldValue(UtilConstants.JH_NUMMER_FIELD_LABEL,soft).equals(UtilConstants.JH_NUMMER_FIELD_VALUE),"Shown value is JH1589 ");
        soft.assertTrue(collectionPage.getFieldValue(UtilConstants.INVENTARISNUMMER_FIELD_LABEL,soft).equals(UtilConstants.INVENTARISNUMMER_FIELD_VALUE),"Shown value is s0032V1962");

        soft.assertAll();
    }

}
