import Utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private ConfigProperties configProperties;
    private String browserName = "";


    @Parameters({"browser", "platform"})
    @BeforeMethod(alwaysRun = true)

    public void setUp() {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            driver = new ChromeDriver();
            launchDriver();

    }

    public void launchDriver() {

        try {
            configProperties = new ConfigProperties();
            driver.get(configProperties.getProperty("applicationUrl"));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 30);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

//    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
