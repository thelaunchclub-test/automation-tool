package com.twozo.commons.listener.suite;

import com.twozo.commons.listener.TestNgListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public interface TestSuiteListener extends TestNgListener {

    default void alterSuite(final List<XmlSuite> suites) {
    }
}