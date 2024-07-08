package com.twozo.extent.report.reporter.internal.spark;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.twozo.extent.report.reporter.internal.extent.AbstractExtentReporter;
import com.twozo.extent.report.reporter.internal.filter.LogStatusFilter;
import com.twozo.extent.report.reporter.internal.order.OrderSummary;
import com.twozo.extent.report.reporter.model.Styles;
import com.twozo.extent.report.reporter.service.Reporter;
import com.twozo.extent.report.test.model.LogStatus;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Provides a range of methods to customize and control the {@link Reporter}.
 * Ensures that the generated {@link Reporter} are comprehensive and tailored to specific requirements.
 * </p>
 *
 * <p>
 * Creates visually appealing {@link Reporter}, allowing for customization of document titles, report names, themes, and more.
 * Integrates functionality for filtering logs based on their {@link LogStatus} and defining the order of report sections.
 * </p>
 *
 * <p>
 * Provides a detailed and customizable report generation process, allowing for easy configuration
 * of test filters and report view orders.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see AbstractExtentReporter
 */
@Getter
public final class SparkReporter extends AbstractExtentReporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparkReporter.class);

    private final ExtentSparkReporter extentSparkReporter;
    private final LogStatusFilter<SparkReporter> filter;
    private final OrderSummary<SparkReporter> viewOrder;

    public SparkReporter(final String path) {
        super();
        this.extentSparkReporter = new ExtentSparkReporter(path);
        this.filter = new LogStatusFilter<>(this);
        this.viewOrder = new OrderSummary<>(this);
    }

    /**
     * <p>
     * Loads the XML configuration file from the specified path and configures the {@link SparkReporter}.
     * </p>
     *
     * @param xmlPath The path to the XML configuration file.
     */
    public void loadXMLConfig(final String xmlPath) {

        try {
            extentSparkReporter.loadXMLConfig(xmlPath);
        } catch (Exception exception) {
            LOGGER.error("Spark: No file found {}", exception.getMessage());
        }
    }

    /**
     * <p>
     * Delegates the call to the config() method of the {@link SparkReporter}.
     * </p>
     *
     * @return {@link ExtentSparkReporter} value containing the configuration settings.
     */
    public ExtentSparkReporterConfig config() {
        return extentSparkReporter.config();
    }

    /**
     * <p>
     * Sets the document title for the {@link AbstractExtentReporter}.
     * </p>
     *
     * @param title The title to set.
     */
    public void setDocumentTitle(final String title) {
        config().setDocumentTitle(title);
    }

    /**
     * <p>
     * Sets the report name for the {@link AbstractExtentReporter}.
     * </p>
     *
     * @param reportName The report name to set.
     */
    public void setReportName(final String reportName) {
        config().setReportName(reportName);
    }

    /**
     * <p>
     * sets the Theme for the {@link SparkReporter}.
     * </p>
     *
     * @param styles The Theme to set.
     */
    public void setTheme(final Styles styles) {
        final Theme theme = Styles.getTheme(styles);

        config().setTheme(theme);
    }

    /**
     * <p>
     * Applies specific {@link LogStatus} criteria to the getReporter.
     * </p>
     *
     * @return The {@link LogStatusFilter} associated with {@link SparkReporter}.
     */
    public LogStatusFilter<SparkReporter> filter() {
        return filter;
    }

    /**
     * <p>
     * Allows the report layout, specifying the order in which different sections should appear.
     * </P>
     *
     * @return {@link OrderSummary} associated with {@link SparkReporter}.
     */
    public OrderSummary<SparkReporter> viewOrder() {
        return viewOrder;
    }
}