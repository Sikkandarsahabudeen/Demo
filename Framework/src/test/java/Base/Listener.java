package Base;

import Resources.ExtentReorts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends baseTest implements ITestListener {
   ExtentReports extent= ExtentReorts.extenReports();
   ExtentTest test;
    ThreadLocal<ExtentTest> Etest=new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
        Etest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Etest.get().log(Status.PASS,"Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  WebDriver driver= null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Etest.get().fail(result.getThrowable());
        String path=takeScreenshot(result.getMethod().getMethodName(), driver);

        Etest.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Ensure that all data is written to the report

    }
}
