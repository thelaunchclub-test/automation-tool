package com.twozo.extent.report.listener.data.provider;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

public interface DataProviderListener extends TestNgListener, IDataProviderListener {

    @Override
    default void beforeDataProviderExecution(final IDataProviderMethod dataProviderMethod, final ITestNGMethod method, final ITestContext testContext) {
    }

    @Override
    default void afterDataProviderExecution(final IDataProviderMethod dataProviderMethod, final ITestNGMethod method, final ITestContext iTestContext) {
    }

    @Override
    default void onDataProviderFailure(final ITestNGMethod method, final ITestContext ctx, final RuntimeException t) {
    }
}

