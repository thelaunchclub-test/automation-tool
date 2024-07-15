package com.twozo.extent.report.listener.report;

import com.twozo.commons.listener.TestNgListener;
import org.testng.IHookCallBack;
import org.testng.ITestResult;

public interface HookableListener extends TestNgListener {

    void run(final IHookCallBack var1, ITestResult var2);
}
