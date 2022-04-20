package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;
    PageLibFunctions pageLibFunctions = new PageLibFunctions(driver,wait);
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
/*
    public WebDriver launchBrowser(){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test");
        return driver;
    }*/

}
