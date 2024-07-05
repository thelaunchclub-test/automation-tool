package com.twozo.listener.interceptor;

import com.twozo.listener.test.TestNgListener;
import org.testng.IMethodInstance;
import org.testng.ITestContext;

import java.util.List;

public interface MethodInterceptor extends TestNgListener {

    List<IMethodInstance> intercept(final List<IMethodInstance> var1, final ITestContext var2);
}
