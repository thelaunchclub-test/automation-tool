package com.twozo.listener.suite;

import com.twozo.listener.test.TestNgListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public interface TestSuiteEnhancer extends TestNgListener {

    default void alterSuite(final List<XmlSuite> suites) {
    }
}