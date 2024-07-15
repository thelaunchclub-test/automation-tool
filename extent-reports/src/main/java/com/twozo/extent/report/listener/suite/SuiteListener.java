package com.twozo.extent.report.listener.suite;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public interface SuiteListener extends TestNgListener, ISuiteListener {

    @Override
    default void onStart(ISuite suite) {
    }

    @Override
    default void onFinish(ISuite suite) {
    }
}
