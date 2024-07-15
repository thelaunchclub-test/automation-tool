package com.twozo.extent.report.listener.execution;


import com.twozo.extent.report.listener.TestNgListener;

public interface ExecutionVisualiser extends TestNgListener {

    void consumeDotDefinition(final String var);
}
