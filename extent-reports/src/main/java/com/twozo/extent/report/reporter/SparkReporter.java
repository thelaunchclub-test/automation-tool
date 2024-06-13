package com.twozo.extent.report.reporter;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.twozo.extent.report.reporter.filter.LogStatusFilter;
import com.twozo.extent.report.reporter.view.order.OrderSummary;
import com.twozo.extent.report.service.ExtentReporterService;
import com.twozo.extent.report.test.status.LogStatus;
import lombok.Getter;

/**
 * <p>
 * Manages the generation of HTML reports. Provides a range of methods to customize and control the
 * reporting process, Ensures that the generated reports are comprehensive and tailored to specific requirements.
 * </p>
 *
 * <p>
 * Creates visually appealing reports, allowing for customization of document titles, report names, themes, and more.
 * Integrates functionality for filtering logs based on their statuses and defining the order of report sections.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 *
 *     getReporter.attachReporter(new ExtentSparkReporter("path/to/report.html"));
 * }</pre>
 * </p>
 *
 * <p>
 * Provides a detailed and customizable report generation process, allowing for easy configuration
 * of test filters and report view orders.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see AbstractExtentReporter
 */
@Getter
public class SparkReporter extends AbstractExtentReporter implements Reporter<SparkReporter> {

    protected final ExtentSparkReporter extentSparkReporter;
    public final LogStatusFilter<SparkReporter> filter;
    private final OrderSummary<SparkReporter> viewOrder;
    private ExtentReporterService report;

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
        } catch (final Exception exception) {
            exception.printStackTrace();
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
     * Sets the theme for the {@link AbstractExtentReporter}.
     * </p>
     *
     * @param theme The theme to set.
     */
    public void setTheme(final Theme theme) {
        config().setTheme(theme);
    }

    /**
     * <p>
     * Attaches the {@link SparkReporter} to the {@link AbstractExtentReporter}.
     * </p>
     */
    public void attach() {
        reports.attachReporter(extentSparkReporter);
    }

    /**
     * <p>
     * Flushes the {@link SparkReporter}.
     * </P>
     */
    public void save() {
        reports.flush();
    }

    /**
     * {@inheritDoc}
     *
     * @param path The file path used to initialize the {@link SparkReporter}.
     * @return A {@link SparkReporter} value, initialized with the provided path.
     */
    @Override
    protected AbstractExtentReporter getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * <p>
     * Applies specific {@link LogStatus} criteria to the getReporter.
     * Allows filtering of test logs based on their statuses, such as PASS, FAIL, SKIP, etc.
     * </p>
     *
     * @return The {@link LogStatusFilter} associated with {@link SparkReporter}.
     */
    public LogStatusFilter<SparkReporter> filter() {
        return filter;
    }

    /**
     * <p>
     * Allows the report layout, specifying the order in which different sections (e.g., TEST, LOG) should appear.
     * </P>
     *
     * @return {@link OrderSummary} associated with {@link SparkReporter}.
     */
    public OrderSummary<SparkReporter> viewOrder() {
        return viewOrder;
    }

    /**
     * <p>
     * Allows to access the current {@link SparkReporter}.
     * </p>
     *
     * @return {@link SparkReporter}.
     */
    @Override
    public SparkReporter getReporter() {
        return this;
    }

    /**
     * <p>
     * Provides access to the {@link ExtentSparkReporter} that is being used
     * by this {@link SparkReporter}.
     * </p
     * >
     * @return {@link ExtentSparkReporter}.
     */
    @Override
    public ExtentSparkReporter getExtentSparkReporter() {
        return extentSparkReporter;
    }
}