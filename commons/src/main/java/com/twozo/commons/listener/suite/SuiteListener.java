package com.twozo.commons.listener.suite;

import com.twozo.commons.listener.TestNgListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public interface SuiteListener extends TestNgListener, ISuiteListener {
    default void onStart(ISuite suite) {
    }

    default void onFinish(ISuite suite) {
    }
}
