package com.twozo.listener.execution;

import com.twozo.listener.test.TestNgListener;

public interface ExecutionListener extends TestNgListener {

    default void onExecutionStart() {
    }

    default void onExecutionFinish() {
    }
}
