/**
 * provides a contract for operations related to test execution and reporting.
 * To interact with test nodes, assign attributes, add snapshots, and manage logging.
 */
package com.extent.reports.test;

import com.aventstack.extentreports.GherkinKeyword;
import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.node.service.Node;
import com.extent.reports.test.screenshot.service.ScreenCapture;
import com.extent.reports.test.status.Status;
import com.extent.reports.test.tabs.service.Tabs;


public interface Test {

    /**
     * Retrieves the current node associated with the tester.
     *
     * @return Node - the current node
     */
    Node getNode();

    Log getLog();

    ScreenCapture getScreenCapture();

    Tabs getTabs();

    /**
     * Assigns an author name to the test.
     *
     * @param name - the name of the author
     * @return Testers - the updated Testers instance
     */
    Test assignAuthor(final String name);

    /**
     * Assigns a category to the test.
     *
     * @param name - the name of the category
     * @return Testers - the updated Testers instance
     */
    Test assignCategory(final String name);

    /**
     * Assigns a device name to the test.
     *
     * @param name - the name of the device
     * @return Testers - the updated Testers instance
     */
    Test assignDevice(final String name);

    /**
     * Adds a snapshot from a file path to the test.
     *
     * @param path - the file path of the snapshot
     * @return Testers - the updated Testers instance
     */
    Test addSnapShotFromPath(final String path);

    /**
     * Adds a snapshot from a Base64 encoded string to the test.
     *
     * @param base64 - the Base64 encoded string of the snapshot
     * @return Testers - the updated Testers instance
     */
    Test addSnapShotFromBase64String(final String base64);

    /**
     * Creates a new test node with the specified name.
     *
     * @param name - the name of the test node
     * @return Testers - the updated Testers instance
     */
    Test createNodeWithName(final String name);

    /**
     * Creates a new test node with the specified name and description.
     *
     * @param name        - the name of the test node
     * @param description - the description of the test node
     * @return Testers - the updated Testers instance
     */
    Test createNodeWithNameAndDesc(final String name, final String description);

    /**
     * Creates a new test node with the specified Gherkin keyword, name, and description.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @param description    - the description of the test node
     * @return Testers - the updated Testers instance
     */
    Test createNodeWithNameAndDescAndGherkin(final GherkinKeyword gherkinKeyword, final String name, final String description);

    /**
     * Creates a new test node with the specified Gherkin keyword and name.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @return Testers - the updated Testers instance
     */
    Test createNodeWithGherkin(final GherkinKeyword gherkinKeyword, final String name);

    /**
     * Sets the log status and details for the current test node.
     *
     * @param status  - the Status enum value
     * @param details - the details to be logged
     */
    void setLog(final Status status, final String details);

}

