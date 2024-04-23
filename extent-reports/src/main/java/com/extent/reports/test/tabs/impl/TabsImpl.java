package com.extent.reports.test.tabs.impl;


import com.extent.reports.test.Test;
import com.extent.reports.test.tabs.service.Tabs;

public class TabsImpl implements Tabs {

    private final Test test;

    public TabsImpl(final Test testGenerator) {
        this.test = testGenerator;
    }
    @Override
    public Test assignAuthor(String name) {
        return test.assignAuthor(name);
    }

    @Override
    public Test assignCategory(String name) {
        return test.assignCategory(name);
    }

    @Override
    public Test assignDevice(String name) {
        return test.assignDevice(name);
    }
}
