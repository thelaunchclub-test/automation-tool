package com.twozo.listener.data.provider;

import com.twozo.listener.test.TestNgListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

public interface DataProviderListener extends TestNgListener {

    default void beforeDataProviderExecution(final IDataProviderMethod dataProviderMethod, final ITestNGMethod method, final ITestContext testContext) {
    }

    default void afterDataProviderExecution(final IDataProviderMethod dataProviderMethod, final ITestNGMethod method, final ITestContext iTestContext) {
    }

    default void onDataProviderFailure(final ITestNGMethod method, final ITestContext ctx, final RuntimeException t) {
    }
}

