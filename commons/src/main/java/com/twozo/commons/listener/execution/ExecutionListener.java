package com.twozo.commons.listener.execution;

import com.twozo.commons.listener.TestNgListener;
import org.testng.IExecutionListener;

public interface ExecutionListener extends IExecutionListener, TestNgListener {

    default void onExecutionStart() {
    }

    default void onExecutionFinish() {
    }
}
