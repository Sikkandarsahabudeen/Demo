package Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/java/Cucumber", // Path to your feature files
        glue = "Definitions", // Package where your step definitions are located
        plugin = {"html:target/cucumber.html"} ,monochrome = true// Optional: reporting
)
public class TestngTestRunner extends AbstractTestNGCucumberTests {
}
