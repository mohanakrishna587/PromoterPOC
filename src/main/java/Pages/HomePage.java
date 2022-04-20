package Pages;

import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

public class HomePage extends BasePage {

    private @FindBy(linkText = "Sign up")
    WebElement signUpLink;
    private @FindBy(xpath = "*//div[@class='d-only']/a[text() ='Log in']")
    WebElement login;
    private @FindBy(xpath = "*//div[@class='d-only']/a[text() ='Home']")
    WebElement linkDemoHome;
    private @FindBy(xpath = "*//a[text() ='Sign up now']")
    WebElement signUpNowLink;
    private @FindBy(xpath = "//input[@name='login_username']")
    WebElement usernameTextInput;
    private @FindBy(xpath = "//input[@name='login_password']")
    WebElement passwordTextInput;
    private @FindBy(xpath = "//button[@class='is-big is-main al-btn'][normalize-space()='Log in']")
    WebElement loginButton;
    private @FindBy(xpath = "//a[text()='I forgot my login details']")
    WebElement forgotCredentialsLink;

    private @FindBy(xpath = "//a[@id='add-item']")
    WebElement addItemIcon;
    ConfigProperties configProperties = new ConfigProperties();
    public HomePage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLoginLinkDisplayed() {
        return login.isDisplayed();
    }

    public boolean login() throws InterruptedException {
        if(isLoginLinkDisplayed()){
            pageLibFunctions.clickElement(login);}
            Thread.sleep(2000);
            if(forgotCredentialsLink.isDisplayed()){
                pageLibFunctions.inputText(configProperties.getProperty("username"),usernameTextInput);
                pageLibFunctions.inputText(configProperties.getProperty("password"),passwordTextInput);
                pageLibFunctions.clickElement(loginButton);
                Thread.sleep(2000);
            }
        return addItemIcon.isDisplayed();
    }


    public FormsDemoPage navigateToFormsPage() {


        pageLibFunctions.setWait(3000);
//        pageLibFunctions.clickElement(simpleForms);

        return new FormsDemoPage(driver);
    }

    public void selectLocation(String City, String Country){
        String myXpath = "//div[@class='item-text']/span[text()='"+City+"']/following-sibling::span[text()='"+Country+"']";
        driver.findElement(By.xpath(myXpath)).click();
    }

}
