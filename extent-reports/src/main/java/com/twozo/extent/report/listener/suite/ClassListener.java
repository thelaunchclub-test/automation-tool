package com.twozo.extent.report.listener.suite;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.ITestClass;

public interface ClassListener extends TestNgListener {

    default void onBeforeClass(final ITestClass testClass) {
    }

    default void onAfterClass(final ITestClass testClass) {
    }
}
