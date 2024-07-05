package com.twozo.listener.test;

import com.twozo.listener.test.TestNgListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public interface TestListener extends TestNgListener {

    default void onTestStart(final ITestResult result) {
    }

    default void onTestSuccess(final ITestResult result) {
    }

    default void onTestFailure(final ITestResult result) {
    }

    default void onTestSkipped(final ITestResult result) {
    }

    default void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    default void onTestFailedWithTimeout(final ITestResult result) {
        this.onTestFailure(result);
    }

    default void onStart(final ITestContext context) {
    }

    default void onFinish(final ITestContext context) {
    }
}