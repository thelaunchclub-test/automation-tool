package com.extent.reports.test.tabs.service;


import com.extent.reports.test.Test;

public interface Tabs {

    Test assignAuthor(final String name);

    Test assignCategory(final String name);

    Test assignDevice(final String name);
}
