package com.twozo.listener.config;

import org.testng.IConfigureCallBack;
import org.testng.ITestResult;

public interface Configurable {
    void run(final IConfigureCallBack var1, final ITestResult var2);
}
