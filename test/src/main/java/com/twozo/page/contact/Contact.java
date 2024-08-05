package com.twozo.page.contact;

import com.twozo.page.BasePage;
import com.twozo.page.Filter;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Contact extends BasePage {

    private static Contact contact;

    private AddContact addContact;
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
    private WebPageElement addContactButton;
    private WebPageElement importContacts;

    protected Contact(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static Contact getInstance(final WebAutomationDriver webAutomationDriver) {

    //    if (Objects.isNull(contact)) {
            contact = new Contact(webAutomationDriver);
      //  }

        return contact;
    }

    public AddContact getAddContact() {

        if (Objects.isNull(addContact)) {
            addContact = AddContact.getInstance(webAutomationDriver);
        }

        return addContact;
    }
    public WebPageElement getColumnSettingsButton() {
        return findByXpath("//*[@class='css-181x7hd']");
    }

    public void switchToColumnSettings() {
        click(getColumnSettingsButton());
    }

    public WebPageElement getFilterIcon() {

        if (Objects.isNull(filterIcon)) {
            filterIcon = findByXpath("//div[@class='css-j7qwjs'][@style='cursor: pointer;']");
        }

        return filterIcon;
    }

    public WebPageElement getFirstName() {

        if (Objects.isNull(firstName)) {
            firstName = findByText("contact.fields.first.name");
        }

        return firstName;
    }

    public WebPageElement getLastName() {

        if (Objects.isNull(lastName)) {
            lastName = findByText("Last Name");
        }

        return lastName;
    }

    public WebPageElement getEmails() {

        if (Objects.isNull(emails)) {
            emails = findByText("Emails");
        }
        return emails;
    }

    public WebPageElement getPhones() {

        if (Objects.isNull(phones)) {
            phones = findByText("Phones");
        }

        return phones;
    }

    public WebPageElement getSource() {

        if (Objects.isNull(source)) {
            source = findByText("Source");
        }

        return source;
    }

    public WebPageElement getStage() {

        if (Objects.isNull(stage)) {
            stage = findByText("Stage");
        }

        return stage;
    }

    public WebPageElement getCompany() {

        if (Objects.isNull(company)) {
            company = findByText("Company");
        }

        return company;
    }

    public WebPageElement getDepartment() {

        if (Objects.isNull(department)) {
            department = findByText("Department");
        }

        return department;
    }

    public WebPageElement getFacebook() {

        if (Objects.isNull(facebook)) {
            facebook = findByText("Facebook");
        }

        return facebook;
    }

    public WebPageElement getTwitter() {

        if (Objects.isNull(twitter)) {
            twitter = findByText("Twitter");
        }

        return twitter;
    }

    public WebPageElement getLinkedIn() {

        if (Objects.isNull(linkedIn)) {
            linkedIn = findByText("Linkedin");
        }

        return linkedIn;
    }

    public WebPageElement getDateOfBirth() {

        if (Objects.isNull(dateOfBirth)) {
            dateOfBirth = findByText("Date of Birth");
        }

        return dateOfBirth;
    }

    public WebPageElement getDesignation() {

        if (Objects.isNull(designation)) {
            designation = findByText("Designation");
        }

        return designation;
    }

    public WebPageElement getCreatedTime() {

        if (Objects.isNull(createdTime)) {
            createdTime = findByText("Created Time");
        }

        return createdTime;
    }

    public WebPageElement getModifiedTime() {

        if (Objects.isNull(modifiedTime)) {
            modifiedTime = findByText("Modified Time");
        }

        return modifiedTime;
    }

    public WebPageElement getTerritory() {

        if (Objects.isNull(territory)) {
            territory = findByText("Territory");
        }

        return territory;
    }

    public WebPageElement getSalesOwner() {

        if (Objects.isNull(salesOwner)) {
            salesOwner = findByText("Sales Owner");
        }

        return salesOwner;
    }

    public WebPageElement getCreatedBy() {

        if (Objects.isNull(createdBy)) {
            createdBy = findByText("Created By");
        }

        return createdBy;
    }

    public WebPageElement getUpdatedBy() {

        if (Objects.isNull(updatedBy)) {
            updatedBy = findByText("Updated By");
        }

        return updatedBy;
    }

    public WebPageElement getRecentNote() {

        if (Objects.isNull(recentNote)) {
            recentNote = findByText("Recent Note");
        }

        return recentNote;
    }

    public WebPageElement getUnsubscribeReason() {

        if (Objects.isNull(unsubscribeReason)) {
            unsubscribeReason = findByText("Unsubscribe reason");
        }

        return unsubscribeReason;
    }

    public WebPageElement getOtherUnsubscribeReason() {

        if (Objects.isNull(otherUnsubscribeReason)) {
            otherUnsubscribeReason = findByText("Other unsubscribe reason");
        }

        return otherUnsubscribeReason;
    }

    public WebPageElement getTags() {

        if (Objects.isNull(tags)) {
            tags = findByText("Tags");
        }

        return tags;
    }

    public WebPageElement getAddContactButton() {

        if (Objects.isNull(addContactButton)) {
            addContactButton = findByText("Contact");
        }

        return addContactButton;
    }

    public AddContact addContact() {
        click(getAddContactButton());

        return getAddContact();
    }

    public Filter switchToFilter() {
        click(getFilterIcon());

        return Filter.getInstance(webAutomationDriver);
    }
}
