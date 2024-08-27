package com.twozo.extent.report.listener.test;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public interface TestListener extends TestNgListener, ITestListener {

    @Override
    default void onTestStart(final ITestResult result) {
    }

    @Override
    default void onTestSuccess(final ITestResult result) {
    }

    @Override
    default void onTestFailure(final ITestResult result) {
    }

    @Override
    default void onTestSkipped(final ITestResult result) {
    }

    @Override
    default void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    @Override
    default void onTestFailedWithTimeout(final ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    default void onStart(final ITestContext context) {
    }

    @Override
    default void onFinish(final ITestContext context) {
    }
}