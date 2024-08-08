package com.twozo.extent.report.listener.execution;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.IExecutionListener;

public interface ExecutionListener extends IExecutionListener, TestNgListener {

    @Override
    default void onExecutionStart() {
    }

    @Override
    default void onExecutionFinish() {
    }
}
