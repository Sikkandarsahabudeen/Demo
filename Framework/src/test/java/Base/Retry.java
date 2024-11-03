package Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0; // Keep track of retry attempts
    private final int maxTry = 1; // Maximum retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++; // Increment the count
            return true; // Indicate that the test should be retried
        }
        return false; // No more retries allowed
    }
}

