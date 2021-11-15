package Services;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.TestRunData;

public class CommonServices {
    public WebElement element;
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    public static TestRunData data = new TestRunData();


    public CommonServices(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method will fill data in input text
     * @param string Input String
     * @param element Input Element
     */
    public void fillData(String string, WebElement element) {

        element.sendKeys(string);
        element.sendKeys(Keys.ENTER);
    }

    public void horizontalScroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element);

    }

    public void verticalScroll(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
    public void smallWait() throws InterruptedException {
        Thread.sleep(1000);
    }

}
