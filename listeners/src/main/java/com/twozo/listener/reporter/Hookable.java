package com.twozo.listener.reporter;

import com.twozo.listener.test.TestNgListener;
import org.testng.IHookCallBack;
import org.testng.ITestResult;

public interface Hookable extends TestNgListener {

    void run(final IHookCallBack var1, ITestResult var2);
}
