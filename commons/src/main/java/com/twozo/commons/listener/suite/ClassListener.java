package com.twozo.commons.listener.suite;

import com.twozo.commons.listener.TestNgListener;
import org.testng.ITestClass;

public interface ClassListener extends TestNgListener {

    default void onBeforeClass(final ITestClass testClass) {
    }

    default void onAfterClass(final ITestClass testClass) {
    }
}
