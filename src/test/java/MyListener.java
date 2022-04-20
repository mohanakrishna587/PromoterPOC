import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" is Passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" is Failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" is Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println(iTestResult.getName()+" is Passed within Success %");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println(iTestContext.getName()+" is Started");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println(iTestContext.getName()+" is Completed");
    }
}
