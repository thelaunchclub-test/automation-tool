package com.twozo.page.activity;

import com.twozo.page.BasePage;
import com.twozo.page.Month;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.List;
import java.util.Objects;

public class AddActivity extends BasePage {

    private static AddActivity addActivity;

    private WebPageElement titleField;
    private WebPageElement type;
    private WebPageElement activityStartDate;
    private WebPageElement activityStartTime;
    private WebPageElement activityEndDate;
    private WebPageElement getActivityEndTime;
    private WebPageElement availability;
    private WebPageElement reminder;
    private WebPageElement priority;
    private WebPageElement salesOwner;
    private WebPageElement collaborators;
    private WebPageElement addGuests;
    private WebPageElement addLocation;
    private WebPageElement addDescription;
    private WebPageElement privateNoteField;
    private WebPageElement dealField;
    private WebPageElement contactField;
    private WebPageElement companyField;
    private WebPageElement saveButton;
    private WebPageElement saveAndNewButton;
    private WebPageElement markAsCompletedCheckBox;
    private WebPageElement closeAddActivityDrawer;


    protected AddActivity(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static AddActivity getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(addActivity)) {

            addActivity = new AddActivity(webAutomationDriver);
        }

        return addActivity;
    }

    private void selectDateForActivity(final int datePickerCount, final Month month, final int date, final int year) {
        final String xpath = "//button[text()='%d']";
        final String calendarIcon = "(//button[contains(@aria-label,'Choose date')])[%d]";

        click(findElement(new Finder(LocatorType.XPATH, String.format(calendarIcon, datePickerCount), true)));
        click(findElement(new Finder(LocatorType.XPATH, "//button[@aria-label='calendar view is open, switch to year view']", true)));
        click(findElement(new Finder(LocatorType.XPATH, String.format(xpath, year), true)));
        final WebPageElement div = findLeftElement(List.of(new Finder(LocatorType.TAG_NAME, "div", false), new Finder(LocatorType.XPATH,
                "//button[@aria-label='calendar view is open, switch to year view']", true)));

        while (!getText(div).equals(String.format("%s %d", month.getName(), year))) {
            click(findElement(new Finder(LocatorType.XPATH, "//button[@aria-label='Next month']", true)));
        }
        click(findElement(new Finder(LocatorType.XPATH, String.format(xpath, date), true)));
    }

    public WebPageElement getTitleField() {

        if (Objects.isNull(titleField)) {
            titleField = findBelowElement(List.of(new Finder(LocatorType.TAG_NAME, "input", false), new Finder(LocatorType.XPATH,
                    "//*[text()='Title']", true)));
        }

        return titleField;
    }

    public WebPageElement getActivityType(final String activityType) {
        final String xpath = "//*[@aria-label='%s']";

        return findElement(new Finder(LocatorType.XPATH, String.format(xpath, activityType),true));

    }
//
//    public WebPageElement getActivityStartDate() {
//
//        if (Objects.isNull(activityStartDate)) {
//            activityStartDate = findElement();
//        }
//
//        return;
//    }
//
//    public WebPageElement getActivityStartTime() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getActivityEndDate() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getGetActivityEndTime() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getAvailability() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getReminder() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getPriority() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getSalesOwner() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getCollaborators() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getAddGuests() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getAddLocation() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getAddDescription() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getPrivateNoteField() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getDealField() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getContactField() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getCompanyField() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getSaveButton() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getSaveAndNewButton() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getMarkAsCompletedCheckBox() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
//
//    public WebPageElement getCloseAddActivityDrawer() {
//
//        if (Objects.isNull()) {
//
//        }
//
//        return;
//    }
}
