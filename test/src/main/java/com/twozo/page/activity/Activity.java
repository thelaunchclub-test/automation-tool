package com.twozo.page.activity;

import com.twozo.page.BasePage;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Activity extends BasePage {

    private static Activity activity;

    private WebPageElement status;
    private WebPageElement title;
    private WebPageElement deal;
    private WebPageElement contacts;
    private WebPageElement company;
    private WebPageElement type;
    private WebPageElement availability;
    private WebPageElement description;
    private WebPageElement startTime;
    private WebPageElement endTime;
    private WebPageElement createdAt;
    private WebPageElement updatedAt;
    private WebPageElement duration;
    private WebPageElement assignedToUser;
    private WebPageElement creator;
    private WebPageElement markedAsDoneTime;
    private WebPageElement lastNotificationTime;
    private WebPageElement reminder;
    private WebPageElement priority;
    private WebPageElement collaborators;
    private WebPageElement location;
    private WebPageElement privateNote;
    private WebPageElement allActivities;
    private WebPageElement taskType;
    private WebPageElement dueDate;
    private WebPageElement statusFilter;
    private WebPageElement listView;
    private WebPageElement calendarView;
    private WebPageElement importActivities;
    private WebPageElement addActivity;

    protected Activity(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Activity getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(activity)) {
            activity = new Activity(webAutomationDriver);
        }

        return activity;
    }

    private WebPageElement findElementWith(final String value) {
        final String xpath = "//*[text()='%s']";

        return findElement(new Finder(LocatorType.XPATH, String.format(xpath, value), true));
    }

    public WebPageElement getStatus() {

        if (Objects.isNull(status)) {
            status = findElement(new Finder(LocatorType.XPATH, "(//*[text()='Status'])[2]", true));
        }

        return status;
    }

    public WebPageElement getTitle() {

        if (Objects.isNull(title)) {
            title = findElementWith("Title");
        }

        return title;
    }

    public WebPageElement getDeal() {

        if (Objects.isNull(deal)) {
            deal = findElementWith("Deal");
        }

        return deal;
    }

    public WebPageElement getContacts() {

        if (Objects.isNull(contacts)) {
            contacts = findElementWith("Contacts");
        }

        return contacts;
    }

    public WebPageElement getCompany() {

        if (Objects.isNull(company)) {
            company = findElementWith("Company");
        }

        return company;
    }

    public WebPageElement getType() {

        if (Objects.isNull(type)) {
            type = findElementWith("Type");
        }

        return type;
    }

    public WebPageElement getAvailability() {

        if (Objects.isNull(availability)) {
            availability = findElementWith("Availability");
        }

        return availability;
    }

    public WebPageElement getDescription() {

        if (Objects.isNull(description)) {
            description = findElementWith("Description");
        }

        return description;
    }

    public WebPageElement getStartTime() {

        if (Objects.isNull(startTime)) {
            startTime = findElementWith("Start Time");
        }

        return startTime;
    }

    public WebPageElement getEndTime() {

        if (Objects.isNull(endTime)) {
            endTime = findElementWith("End Time");
        }

        return endTime;
    }

    public WebPageElement getCreatedAt() {

        if (Objects.isNull(createdAt)) {
            createdAt = findElementWith("Created At");
        }

        return createdAt;
    }

    public WebPageElement getUpdatedAt() {

        if (Objects.isNull(updatedAt)) {
            updatedAt = findElementWith("Updated At");
        }

        return updatedAt;
    }

    public WebPageElement getDuration() {

        if (Objects.isNull(duration)) {
            duration = findElementWith("Duration");
        }

        return duration;
    }

    public WebPageElement getAssignedToUser() {

        if (Objects.isNull(assignedToUser)) {
            assignedToUser = findElementWith("Assigned To User");
        }

        return assignedToUser;
    }

    public WebPageElement getCreator() {

        if (Objects.isNull(creator)) {
            creator = findElementWith("Creator");
        }

        return creator;
    }

    public WebPageElement getMarkedAsDoneTime() {

        if (Objects.isNull(markedAsDoneTime)) {
            markedAsDoneTime = findElementWith("Marked as done time");
        }

        return markedAsDoneTime;
    }

    public WebPageElement getLastNotificationTime() {

        if (Objects.isNull(lastNotificationTime)) {
            lastNotificationTime = findElementWith("Last notification time");
        }

        return lastNotificationTime;
    }

    public WebPageElement getReminder() {

        if (Objects.isNull(reminder)) {
            reminder = findElementWith("Reminder");
        }

        return reminder;
    }

    public WebPageElement getPriority() {

        if (Objects.isNull(priority)) {
            priority = findElementWith("Priority");
        }

        return priority;
    }

    public WebPageElement getCollaborators() {

        if (Objects.isNull(collaborators)) {
            collaborators = findElementWith("Collaborators");
        }

        return collaborators;
    }

    public WebPageElement getLocation() {

        if (Objects.isNull(location)) {
            location = findElementWith("Location");
        }

        return location;
    }

    public WebPageElement getPrivateNote() {

        if (Objects.isNull(privateNote)) {
            privateNote = findElementWith("Private note");
        }

        return privateNote;
    }

    public WebPageElement getAllActivities() {

        if (Objects.isNull(allActivities)) {
            allActivities = findElementWith("All Activities");
        }

        return allActivities;
    }

    public WebPageElement getTaskType() {

        if (Objects.isNull(taskType)) {
            taskType = findElementWith("Task Type");
        }

        return taskType;
    }

    public WebPageElement getDueDate() {

        if (Objects.isNull(dueDate)) {
            dueDate = findElementWith("Due Date");
        }

        return dueDate;
    }

    public WebPageElement getStatusFilter() {

        if (Objects.isNull(statusFilter)) {
            statusFilter = findElementWith("Status");
        }

        return statusFilter;
    }


    public WebPageElement getListView() {

        if (Objects.isNull(statusFilter)) {
            statusFilter = findElement(new Finder(LocatorType.XPATH, "//button[@value='list']", true));
        }

        return statusFilter;
    }

    public WebPageElement getCalendarView() {

        if (Objects.isNull(calendarView)) {
            calendarView = findElement(new Finder(LocatorType.XPATH, "//button[@value='calendar']", true));
        }

        return calendarView;
    }

    public WebPageElement getImportActivities() {

        if (Objects.isNull(importActivities)) {
            importActivities = findElementWith("Import Activities");
        }

        return importActivities;
    }

    public WebPageElement getAddActivity() {

        if (Objects.isNull(addActivity)) {
            addActivity = findElementWith("Activity");
        }

        return addActivity;
    }

    public AddActivity addActivity() {
        click(getCalendarView());
        click(getAddActivity());
        return AddActivity.getInstance(webAutomationDriver);
    }
}

