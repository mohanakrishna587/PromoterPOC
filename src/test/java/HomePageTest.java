import Pages.FormsDemoPage;
import Pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @Test(groups = { "Sanity", "Regression" })
    public void verifyTitle(){
        homePage  =  PageFactory.initElements(getDriver(),HomePage.class);
        Assert.assertEquals( homePage.getTitle(),"Home | Equinepromoter");
    }

    @Test
    public void testLoginFunctionality() throws InterruptedException {
        homePage = PageFactory.initElements(getDriver(),HomePage.class);
        Assert.assertEquals(true,homePage.login());
    }

    @Test(groups = "Sanity")
    public void testNavigateToForms()  {
        homePage  =  PageFactory.initElements(getDriver(),HomePage.class);
        FormsDemoPage formsDemoPage = homePage.navigateToFormsPage();
        Assert.assertEquals(true,formsDemoPage.testShowMessageButton());
    }

}
