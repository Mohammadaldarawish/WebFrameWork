package listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: {}", result.getName());
        logger.debug("Test class: {}, Method: {}", result.getTestClass().getName(), result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: {}", result.getName());
        logger.debug("Execution time: {} ms", (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: {}", result.getName());
        logger.debug("Failure reason: {}", result.getThrowable().getMessage(), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: {}", result.getName());
        logger.debug("Skip reason: {}", result.getThrowable() != null ? result.getThrowable().getMessage() : "No reason provided");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test Failed but within Success Percentage: {}", result.getName());
        logger.debug("Execution time: {} ms", (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started: {}", context.getName());
        logger.debug("Included groups: {}", String.join(", ", context.getIncludedGroups()));
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished: {}", context.getName());
        logger.debug("Excluded groups: {}", String.join(", ", context.getExcludedGroups()));
        logger.debug("Passed tests: {}, Failed tests: {}, Skipped tests: {}",
                context.getPassedTests().size(),
                context.getFailedTests().size(),
                context.getSkippedTests().size());
    }
}