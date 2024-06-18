package com.twozo.page.contact;

import com.twozo.page.BasePage;
import com.twozo.page.Filter;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Contact extends BasePage {

    private static Contact contact;
    private WebPageElement filterIcon;
    private WebPageElement firstName;
    private WebPageElement lastName;
    private WebPageElement emails;
    private WebPageElement phones;
    private WebPageElement source;
    private WebPageElement stage;
    private WebPageElement company;
    private WebPageElement department;
    private WebPageElement facebook;
    private WebPageElement twitter;
    private WebPageElement linkedIn;
    private WebPageElement dateOfBirth;
    private WebPageElement designation;
    private WebPageElement createdTime;
    private WebPageElement modifiedTime;
    private WebPageElement territory;
    private WebPageElement salesOwner;
    private WebPageElement createdBy;
    private WebPageElement updatedBy;
    private WebPageElement recentNote;
    private WebPageElement unsubscribeReason;
    private WebPageElement otherUnsubscribeReason;
    private WebPageElement tags;

    protected Contact(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Contact getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(contact)) {
            contact = new Contact(webAutomationDriver);
        }

        return contact;
    }

    private WebPageElement findElementWith(final String value) {
        final String xpath = "//*[text()='%s']";

        return findElement(new Finder(LocatorType.XPATH, String.format(xpath, value),true));
    }

    public WebPageElement getFilterIcon() {

        if (Objects.isNull(filterIcon)) {
            filterIcon = findElement(new Finder(LocatorType.XPATH, "//div[@class='css-j7qwjs'][@style='cursor: pointer;']",true));
        }

        return filterIcon;
    }

    public WebPageElement getFirstName() {

        if (Objects.isNull(firstName)) {
            firstName = findElementWith("First Name");
        }

        return firstName;
    }

    public WebPageElement getLastName() {

        if (Objects.isNull(lastName)) {
            lastName = findElementWith("Last Name");
        }

        return lastName;
    }

    public WebPageElement getEmails() {

        if (Objects.isNull(emails)) {
            emails = findElementWith("Emails");
        }
        return emails;
    }

    public WebPageElement getPhones() {

        if (Objects.isNull(phones)) {
            phones = findElementWith("Phones");
        }

        return phones;
    }

    public WebPageElement getSource() {

        if (Objects.isNull(source)) {
            source = findElementWith("Source");
        }

        return source;
    }

    public WebPageElement getStage() {

        if (Objects.isNull(stage)) {
            stage = findElementWith("Stage");
        }

        return stage;
    }

    public WebPageElement getCompany() {

        if (Objects.isNull(company)) {
            company = findElementWith("Company");
        }

        return company;
    }

    public WebPageElement getDepartment() {

        if (Objects.isNull(department)) {
            department = findElementWith("Department");
        }

        return department;
    }

    public WebPageElement getFacebook() {

        if (Objects.isNull(facebook)) {
            facebook = findElementWith("Facebook");
        }

        return facebook;
    }

    public WebPageElement getTwitter() {

        if (Objects.isNull(twitter)) {
            twitter = findElementWith("Twitter");
        }

        return twitter;
    }

    public WebPageElement getLinkedIn() {

        if (Objects.isNull(linkedIn)) {
            linkedIn = findElementWith("Linkedin");
        }

        return linkedIn;
    }

    public WebPageElement getDateOfBirth() {

        if (Objects.isNull(dateOfBirth)) {
            dateOfBirth = findElementWith("Date of Birth");
        }

        return dateOfBirth;
    }

    public WebPageElement getDesignation() {

        if (Objects.isNull(designation)) {
            designation = findElementWith("Designation");
        }

        return designation;
    }

    public WebPageElement getCreatedTime() {

        if (Objects.isNull(createdTime)) {
            createdTime = findElementWith("Created Time");
        }

        return createdTime;
    }

    public WebPageElement getModifiedTime() {

        if (Objects.isNull(modifiedTime)) {
            modifiedTime = findElementWith("Modified Time");
        }

        return modifiedTime;
    }

    public WebPageElement getTerritory() {

        if (Objects.isNull(territory)) {
            territory = findElementWith("Territory");
        }

        return territory;
    }

    public WebPageElement getSalesOwner() {

        if (Objects.isNull(salesOwner)) {
            salesOwner = findElementWith("Sales Owner");
        }

        return salesOwner;
    }

    public WebPageElement getCreatedBy() {

        if (Objects.isNull(createdBy)) {
            createdBy = findElementWith("Created By");
        }

        return createdBy;
    }

    public WebPageElement getUpdatedBy() {

        if (Objects.isNull(updatedBy)) {
            updatedBy = findElementWith("Updated By");
        }

        return updatedBy;
    }

    public WebPageElement getRecentNote() {

        if (Objects.isNull(recentNote)) {
            recentNote = findElementWith("Recent Note");
        }

        return recentNote;
    }

    public WebPageElement getUnsubscribeReason() {

        if (Objects.isNull(unsubscribeReason)) {
            unsubscribeReason = findElementWith("Unsubscribe reason");
        }

        return unsubscribeReason;
    }

    public WebPageElement getOtherUnsubscribeReason() {

        if (Objects.isNull(otherUnsubscribeReason)) {
            otherUnsubscribeReason = findElementWith("Other unsubscribe reason");
        }

        return otherUnsubscribeReason;
    }

    public WebPageElement getTags() {

        if (Objects.isNull(tags)) {
            tags = findElementWith("Tags");
        }

        return tags;
    }


    public Filter switchToFilter() {
        click(getFilterIcon());

        return Filter.getInstance(webAutomationDriver);
    }


}
