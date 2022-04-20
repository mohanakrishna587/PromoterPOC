package Pages;

import Utils.MyReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageLibFunctions {
    WebDriver driver;
    private WebDriverWait wait;
    MyReporter reporter = new MyReporter();
    public PageLibFunctions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickElement(WebElement element) {
        if (element.isDisplayed()) {
            reporter.reportPassEvent(element.getText() + " is clicked successfully");
            element.click();
        } else {
            reporter.reportFailEvent("Unable to click element");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        setWait(5000);
        boolean flag = false;
        if (element.isDisplayed()) {
            flag = true;
            reporter.reportPassEvent(element.getText() + " is displayed successfully");
        }
        return flag;
    }

    public void waitForElementTobedisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setWait(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputText(String text,WebElement element){
        if(isElementDisplayed(element)){
            element.sendKeys(text);
        }
    }
}
