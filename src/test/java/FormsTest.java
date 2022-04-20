import Pages.FormsDemoPage;
import Pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyListener.class})
public class FormsTest extends BaseTest {

    private FormsDemoPage formsDemoPage;
    private HomePage homePage;


    @Test
    public void verifyTitle(){
        homePage = PageFactory.initElements(getDriver(),HomePage.class);
        Assert.assertEquals( "Selenium Easy Demo - Simple Form to Automate using Selenium",homePage.getTitle());
    }

    @Test
    public void testNavigateToForms()  {
        homePage = PageFactory.initElements(getDriver(),HomePage.class);
        formsDemoPage = homePage.navigateToFormsPage();
        Assert.assertEquals(true,formsDemoPage.testShowMessageButton());
        Reporter.log("Navigated to Forms Successfully");

    }

    @Test(dataProvider="Names",groups = "Sanity",dataProviderClass = TestData.class)
    public void testEditForm(String name){
        homePage = PageFactory.initElements(getDriver(),HomePage.class);
        formsDemoPage = homePage.navigateToFormsPage();
        Assert.assertEquals(true,formsDemoPage.testShowMessageButton());
        Assert.assertEquals(true,formsDemoPage.testTextBox(name));
        Reporter.log("Successfully tested Name edit forms");
    }

    @Test(groups = "Sanity" ,dataProvider = "Additions", dataProviderClass = TestData.class)
    public void testSumEdit(String a, String b, String c){
        homePage = PageFactory.initElements(getDriver(),HomePage.class);
        formsDemoPage = homePage.navigateToFormsPage();
        Assert.assertEquals(true,formsDemoPage.testShowMessageButton());
        Assert.assertEquals(true,formsDemoPage.testSum(a,b,c));
        Reporter.log("Successfully tested Additions edit forms");
    }

    @DataProvider(name = "NamesData")
    public Object[][] dpMethod(){
        return new Object[][]{{"Bhavya"},{"Mohan"}};
    }

}
