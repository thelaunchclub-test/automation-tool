package com.twozo.extent.report.listener.method;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public interface InvokeMethodListener extends TestNgListener, IInvokedMethodListener {

    @Override
    default void beforeInvocation(final IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    default void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    default void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    @Override
    default void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }
}
