package com.twozo.extent.report.listener.suite;


import com.twozo.extent.report.listener.TestNgListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public interface TestSuiteListener extends TestNgListener {

    default void alterSuite(final List<XmlSuite> suites) {
    }
}