package com.twozo.commons.listener.method;

import com.twozo.commons.listener.TestNgListener;
import org.testng.IMethodInstance;
import org.testng.ITestContext;

import java.util.List;


public interface MethodInterceptorListener extends TestNgListener {

    List<IMethodInstance> intercept(final List<IMethodInstance> methodInstanceList, final ITestContext testContext);
}
