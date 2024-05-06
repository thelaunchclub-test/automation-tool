package com.extent.reports.test;

import com.aventstack.extentreports.GherkinKeyword;

import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.node.service.Node;
import com.extent.reports.test.screenshot.service.ScreenCapture;
import com.extent.reports.test.status.Status;
import com.extent.reports.test.tabs.service.Tabs;

/**
 * Defines the contract for a test object
 * that encapsulates various functionalities for managing and reporting
 * test execution details.
 *
 * <p>
 * This interface provides methods to interact with test nodes, logs,
 * screen captures, and tabs. It also includes methods for assigning
 * authors, categories, and devices to tests, as well as adding snapshots
 * and creating test nodes with various configurations.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Node
 * @see Log
 * @see ScreenCapture
 * @see Tabs
 * @see GherkinKeyword
 * @see Status
 */
public interface ReportTest {

    /**
     * Retrieves the current node associated with the test.
     *
     * @return Node - the current test node
     * @see Node
     */
    Node getNode();

    /**
     * Retrieves the log instance associated with the test.
     *
     * @return Log - the log instance
     * @see Log
     */
    Log getLog();

    /**
     * Retrieves the screen capture instance associated with the test.
     *
     * @return ScreenCapture - the screen capture instance
     * @see ScreenCapture
     */
    ScreenCapture getScreenCapture();

    /**
     * Retrieves the tabs instance associated with the test.
     *
     * @return Tabs - the tabs instance
     * @see Tabs
     */
    Tabs getTabs();

    /**
     * Assigns an author name to the test.
     *
     * @param name - the name of the author
     * @return Test - the updated Test instance
     */
    ReportTest assignAuthor(final String name);

    /**
     * Assigns a category to the test.
     *
     * @param name - the name of the category
     * @return Test - the updated Test instance
     */
    ReportTest assignCategory(final String name);

    /**
     * Assigns a device name to the test.
     *
     * @param name - the name of the device
     * @return Test - the updated Test instance
     */
    ReportTest assignDevice(final String name);

    /**
     * Adds a snapshot from a file path to the test.
     *
     * @param path - the file path of the snapshot
     * @return Test - the updated Test instance
     */
    ReportTest addSnapShotFromPath(final String path);

    /**
     * Adds a snapshot from a Base64 encoded string to the test.
     *
     * @param base64 - the Base64 encoded string of the snapshot
     * @return Test - the updated Test instance
     */
    ReportTest addSnapShotFromBase64String(final String base64);

    /**
     * Creates a new test node with the specified name.
     *
     * @param name - the name of the test node
     * @return Test - the updated Test instance
     */
    ReportTest createNode(final String name);

    /**
     * Creates a new test node with the specified name and description.
     *
     * @param name        - the name of the test node
     * @param description - the description of the test node
     * @return Test - the updated Test instance
     */
    ReportTest createNode(final String name, final String description);

    /**
     * Creates a new test node with the specified Gherkin keyword, name, and description.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @param description    - the description of the test node
     * @return Test - the updated Test instance
     */
    ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name, final String description);

    /**
     * Creates a new test node with the specified Gherkin keyword and name.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @return Test - the updated Test instance
     */
    ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name);

    /**
     * Sets the log status and details for the current test node.
     *
     * @param status  - the Status enum value
     * @param details - the details to be logged
     * @see Status
     */
    void setLog(final Status status, final String details);

    /**
     * Logs an informational message.
     *
     * @param message The message to be logged.
     */

    void LogInfo(final String message);

    /**
     * Logs a pass status along with a message.
     *
     * @param message The message to be logged.
     */
    void LogPass(final String message);

    /**
     * Logs a fail status along with a message.
     *
     * @param message The message to be logged.
     */
    void LogFail(final String message);

    /**
     * Logs a skip status along with a message.
     *
     * @param message The message to be logged.
     */
    void LogSkip(final String message);

    /**
     * Logs a warning status along with a message.
     *
     * @param message The message to be logged.
     */
    void LogWarning(final String message);

}

