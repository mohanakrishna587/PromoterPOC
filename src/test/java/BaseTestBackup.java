import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class BaseTestBackup {
    private WebDriver driver;
    private WebDriverWait wait;
    private ConfigProperties configProperties;
    private String browserName = "";
//    protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();

    @Parameters({"browser", "platform"})
    @BeforeMethod(alwaysRun = true)
//    public void setUp(String browserName, String platformName, Method name) {
    public void setUp() {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            driver = new ChromeDriver();
            launchDriver();
/*        String mName = name.getName();
        MutableCapabilities sauceCaps = new MutableCapabilities();
        sauceCaps.setCapability("name",mName);
        sauceCaps.setCapability("build", "Java-W3C-Examples");
        sauceCaps.setCapability("seleniumVersion", "3.141.59");
        sauceCaps.setCapability("username", "oauth-mohanakrishna587-1daeb");
        sauceCaps.setCapability("accessKey", "cf503295-dc1c-415a-bea4-9839088e60e2");
        sauceCaps.setCapability("tags", "w3c-chrome-tests");*/

        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("sauce:option", sauceCaps);
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", platformName);
        caps.setCapability("username", "oauth-mohanakrishna587-1daeb");
        caps.setCapability("accessKey", "cf503295-dc1c-415a-bea4-9839088e60e2");
        caps.setCapability("Name",mName);*/

        /*if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            caps.setCapability("browserName", "chrome");
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            caps.setCapability("browserName", "firefox");
        }*/
            //https://oauth-mohanakrishna587-1daeb:cf503295-dc1c-415a-bea4-9839088e60e2@ondemand.eu-central-1.saucelabs.com:443/wd/hub
        /*try {
            driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
//        launchDriver();

    }

    public void launchDriver() {

        try {
            configProperties = new ConfigProperties();
//            WebDriver browser = getDriver();
            driver.get(configProperties.getProperty("applicationUrl"));
            wait = new WebDriverWait(driver, 30);
            Thread.sleep(3000);
            WebElement desclaimerPopUp = driver.findElement(By.xpath("//div/a[text()='No, thanks!']"));
            desclaimerPopUp.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
//        driver.get().close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
