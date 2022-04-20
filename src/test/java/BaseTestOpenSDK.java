import Utils.ConfigProperties;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.ReportType;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StringUtils;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class BaseTestOpenSDK {
    private ChromeDriver driver;
    private WebDriverWait wait;
    private ConfigProperties configProperties;
    private String browserName = "";

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        if (StringUtils.isEmpty(System.getenv().get("TP_DEV_TOKEN"))) {
            throw new SkipException("TP_DEV_TOKEN Environment Variable is not defined or empty");
        }
        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withReportType(ReportType.LOCAL)
                .withReportPath("C:\\FMTI-Mohan\\Reports")
                .build(ChromeDriver.class);

    }

    public void launchDriver() {

        try {
            configProperties = new ConfigProperties();
            driver.get(configProperties.getProperty("applicationUrl"));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 30);
            Thread.sleep(3000);
            driver.report().step("Application Launched Successfully",true);
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
        driver.quit();

}

    public ChromeDriver getDriver() {
        return driver;
    }
}
