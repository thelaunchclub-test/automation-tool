package com.twozo.listener.execution;

import com.twozo.listener.test.TestNgListener;

public interface ExecutionVisualiser extends TestNgListener {

    void consumeDotDefinition(final String var);
}
