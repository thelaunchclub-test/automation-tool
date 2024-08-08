package com.twozo.extent.report.listener.method;

import com.twozo.extent.report.listener.TestNgListener;
import org.testng.IMethodInstance;
import org.testng.ITestContext;

import java.util.List;

public interface MethodInterceptorListener extends TestNgListener {

    List<IMethodInstance> intercept(final List<IMethodInstance> methodInstanceList, final ITestContext testContext);
}
