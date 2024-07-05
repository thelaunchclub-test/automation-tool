package com.twozo.listener.interceptor;

import com.twozo.listener.test.TestNgListener;
import org.testng.ITestClass;

public interface ClassHandler extends TestNgListener {

    default void onBeforeClass(final ITestClass testClass) {
    }

    default void onAfterClass(final ITestClass testClass) {
    }
}
