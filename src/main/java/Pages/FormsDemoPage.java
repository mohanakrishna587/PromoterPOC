package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsDemoPage extends BasePage {
    private @FindBy(xpath = "//button[normalize-space()='Show Message']")
    WebElement btnShowMessage;
    private @FindBy(xpath = "//input[@id='user-message']")
    WebElement editUserMessage;
    private @FindBy(xpath = "//span[@id='display']")
    WebElement txtDisplayedMsg;
    private @FindBy(xpath = "//input[@id='sum1']")
    WebElement editSum1;
    private @FindBy(xpath = "//input[@id='sum2']")
    WebElement editSum2;
    private @FindBy(xpath = "//button[normalize-space()='Get Total']")
    WebElement btnGetTotal;
    private @FindBy(xpath = "//span[@id='displayvalue']")
    WebElement txtDisplayedSum;


    public FormsDemoPage(WebDriver driver) {
        super(driver);
    }

    public boolean testShowMessageButton(){
        return pageLibFunctions.isElementDisplayed(btnShowMessage);
    }

    public boolean testTextBox(String text){
        boolean flag = false;
        pageLibFunctions.inputText(text,editUserMessage);
        pageLibFunctions.clickElement(btnShowMessage);
        pageLibFunctions.isElementDisplayed(txtDisplayedMsg);
        if(txtDisplayedMsg.getText().equals(text)){
            flag = true;
        }
            return flag;
        }

    public boolean testSum(String a, String b, String c){
        boolean flag = false;
        pageLibFunctions.inputText(a,editSum1);
        pageLibFunctions.inputText(b,editSum2);
        pageLibFunctions.clickElement(btnGetTotal);
        if(txtDisplayedSum.getText().equals(c)){
            flag = true;
        }
        return flag;
        }
    }






