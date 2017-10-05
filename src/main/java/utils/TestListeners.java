package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName()+ " started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName() + " passed.");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName() + " failed with result: " + iTestResult.getThrowable());
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
