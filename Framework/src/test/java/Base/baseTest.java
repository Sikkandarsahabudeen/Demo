package Base;

import Pages.logIN;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class baseTest{
    public WebDriver driver;
    public logIN lg;



    public WebDriver intialsetup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
    @AfterTest(alwaysRun = true)
    public void endSetup(){
        driver.quit();
    }

     @BeforeTest(alwaysRun = true)
    public logIN initializeDriver(){
        driver=intialsetup();
         lg =new logIN(driver);
        lg.Goto();
        return lg;

    }

    public String takeScreenshot(String testcasename, WebDriver driver){
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"//reports//"+testcasename +".png");
        try {
            FileUtils.copyFile(source,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return System.getProperty("user.dir")+"//reports//"+testcasename +".png";
    }
    @After
    public void tearDown(Scenario scenario) {
        // Call TestNG listener's report generation method
        Listener listener = new Listener();
        listener.onTestFailure(scenario); // Customize this method to accept a scenario or its result

        if (scenario.isFailed()) {
            takeScreenshot(scenario.getName());
        }
        driver.quit();
    }



}
