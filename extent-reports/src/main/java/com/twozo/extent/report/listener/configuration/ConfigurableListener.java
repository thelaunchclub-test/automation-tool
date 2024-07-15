package com.twozo.extent.report.listener.configuration;

import org.testng.IConfigureCallBack;
import org.testng.ITestResult;

public interface ConfigurableListener {

    void run(final IConfigureCallBack var1, final ITestResult var2);
}
