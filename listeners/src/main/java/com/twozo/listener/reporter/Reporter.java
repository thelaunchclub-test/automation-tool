package com.twozo.listener.reporter;

import com.twozo.listener.test.TestNgListener;
import org.testng.ISuite;
import org.testng.reporters.IReporterConfig;
import org.testng.reporters.PojoReporterConfig;
import org.testng.xml.XmlSuite;

import java.util.List;

public interface Reporter extends TestNgListener {

    default void generateReport(final List<XmlSuite> xmlSuites, final List<ISuite> suites, final String outputDirectory) {
    }

    default IReporterConfig getConfig() {
        return new PojoReporterConfig(this);
    }
}