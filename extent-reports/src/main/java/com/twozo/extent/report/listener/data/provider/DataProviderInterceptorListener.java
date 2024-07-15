package com.twozo.extent.report.listener.data.provider;

import com.twozo.commons.listener.TestNgListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.Iterator;

public interface DataProviderInterceptorListener extends TestNgListener {

    Iterator<Object[]> intercept(final Iterator<Object[]> var1, final IDataProviderMethod var2, final ITestNGMethod var3, final ITestContext var4);
}
