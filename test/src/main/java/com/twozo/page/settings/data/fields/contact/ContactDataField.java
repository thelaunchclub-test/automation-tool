package com.twozo.page.settings.data.fields.contact;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.page.settings.data.fields.field.FieldTypePath;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.url.settings.URL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.status.WebDriverErrorCode;
import org.openqa.selenium.NoSuchElementException;

import java.util.Arrays;
import java.util.List;

public class ContactDataField extends AbstractDataField {

    private static ContactDataField contactDataField;

    protected ContactDataField(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (!getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }


    public static ContactDataField getInstance(final WebAutomationDriver webAutomationDriver) {
        contactDataField = new ContactDataField(webAutomationDriver);

        return contactDataField;
    }

    public String getFirstNameDiv() {
        return getFieldBlock(ContactField.FIRST_NAME);
    }

    public String getLastNameDiv() {
        return getFieldBlock(ContactField.LAST_NAME);
    }

    public String getEmailDiv() {
        return getFieldBlock(ContactField.EMAILS);
    }

    public String getPhonesDiv() {
        return getFieldBlock(ContactField.PHONES);
    }

    public String getCompanyDiv() {
        return getFieldBlock(ContactField.COMPANY);
    }

    public String getDesignationDiv() {
        return getFieldBlock(ContactField.DESIGNATION);
    }

    public String getSalesOwnerDiv() {
        return getFieldBlock(ContactField.SALES_OWNER);
    }

    public String getFacebookDiv() {
        return getFieldBlock(ContactField.FACEBOOK);
    }

    public String getTwitterDiv() {
        return getFieldBlock(ContactField.LINKED_IN);
    }

    private SystemField getFirstNameField() {
        final String firstNameDiv = getFirstNameDiv();
        return new SystemField(
                findByXpath(format(firstNameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(firstNameDiv, XPathBuilder.getXPathByText(ContactField.FIRST_NAME.getName()))),
                findByXpath(format(firstNameDiv, XPathBuilder.getXPathByText(ContactField.FIRST_NAME.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(firstNameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(firstNameDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLastNameField() {
        final String lastNameDiv = getLastNameDiv();

        return new SystemField(
                findByXpath(format(lastNameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(lastNameDiv, XPathBuilder.getXPathByText(ContactField.LAST_NAME.getName()))),
                findByXpath(format(lastNameDiv, XPathBuilder.getXPathByText(ContactField.LAST_NAME.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(lastNameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(lastNameDiv, FieldElement.REQUIRED_CHECKBOX))), null);
    }

    private SystemField getEmailsField() {
        final String emailDiv = getEmailDiv();

        return new SystemField(
                findByXpath(format(emailDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(emailDiv, XPathBuilder.getXPathByText(ContactField.EMAILS.getName()))),
                findByXpath(format(emailDiv, XPathBuilder.getXPathByText(ContactField.EMAILS.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(emailDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(emailDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getPhonesField() {
        final String phonesDiv = getPhonesDiv();

        return new SystemField(
                findByXpath(format(phonesDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(phonesDiv, XPathBuilder.getXPathByText(ContactField.PHONES.getName()))),
                findByXpath(format(phonesDiv, XPathBuilder.getXPathByText(ContactField.PHONES.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(phonesDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(phonesDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getCompanyField() {
        final String companyDiv = getCompanyDiv();

        return new SystemField(
                findByXpath(format(companyDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(companyDiv, XPathBuilder.getXPathByText(ContactField.COMPANY.getName()))),
                findByXpath(format(companyDiv, XPathBuilder.getXPathByText(ContactField.COMPANY.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(companyDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(companyDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getDesignationField() {
        final String designationDiv = getDesignationDiv();

        return new SystemField(
                findByXpath(format(designationDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(designationDiv, XPathBuilder.getXPathByText(ContactField.DESIGNATION.getName()))),
                findByXpath(format(designationDiv, XPathBuilder.getXPathByText(ContactField.DESIGNATION.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(designationDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(designationDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getSalesOwnerField() {
        final String salesOwnerDiv = getSalesOwnerDiv();

        return new SystemField(
                findByXpath(format(salesOwnerDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(ContactField.SALES_OWNER.getName()))),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(ContactField.SALES_OWNER.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getFacebookField() {
        final String facebookDiv = getFacebookDiv();
        return new SystemField(
                findByXpath(format(facebookDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(facebookDiv, XPathBuilder.getXPathByText(ContactField.FACEBOOK.getName()))),
                findByXpath(format(facebookDiv, XPathBuilder.getXPathByText(ContactField.FACEBOOK.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(facebookDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(facebookDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLinkedInField() {
        final String twitterDiv = getTwitterDiv();
        return new SystemField(
                findByXpath(format(twitterDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(twitterDiv, XPathBuilder.getXPathByText(ContactField.LINKED_IN.getName()))),
                findByXpath(format(twitterDiv, XPathBuilder.getXPathByText(ContactField.LINKED_IN.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(twitterDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(twitterDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }


    public boolean verifyActiveContactTab() {
        return isDisplayed(getActiveContactTab());
    }

    public boolean emailOrPhoneShouldBeRequired() {
        return isSelected(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKBOX))) ||
                isSelected(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKBOX)));
    }

    public void checkChoicesForSource() {
        final String[] sources = {
                "Web",
                "Organic Search",
                "Email",
                "Phone",
                "Chat",
                "Web Form",
                "Referral",
                "Direct",
                "Paid Search",
                "Blogs",
                "Social Media",
                "Display Ads",
                "Events",
                "Webinar"
        };

        for (final String source : sources) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(source)));
        }
    }

    public void checkChoicesForTimeZone() {
        final String[] timeZones = {
                "(UTC+00:00) Africa/Abidjan",
                "(UTC+00:00) Africa/Accra",
                "(UTC+03:00) Africa/Addis_Ababa",
                "(UTC+01:00) Africa/Algiers",
                "(UTC+03:00) Africa/Asmara",
                "(UTC+03:00) Africa/Asmera",
                "(UTC+00:00) Africa/Bamako",
                "(UTC+01:00) Africa/Bangui",
                "(UTC+00:00) Africa/Banjul",
                "(UTC+00:00) Africa/Bissau",
                "(UTC+02:00) Africa/Blantyre",
                "(UTC+01:00) Africa/Brazzaville",
                "(UTC+02:00) Africa/Bujumbura",
                "(UTC+02:00) Africa/Cairo",
                "(UTC+00:00) Africa/Casablanca",
                "(UTC+01:00) Africa/Ceuta",
                "(UTC+00:00) Africa/Conakry",
                "(UTC+00:00) Africa/Dakar",
                "(UTC+03:00) Africa/Dar_es_Salaam",
                "(UTC+03:00) Africa/Djibouti",
                "(UTC+01:00) Africa/Douala",
                "(UTC+00:00) Africa/El_Aaiun",
                "(UTC+00:00) Africa/Freetown",
                "(UTC+02:00) Africa/Gaborone",
                "(UTC+02:00) Africa/Harare",
                "(UTC+02:00) Africa/Johannesburg",
                "(UTC+02:00) Africa/Juba",
                "(UTC+03:00) Africa/Kampala",
                "(UTC+02:00) Africa/Khartoum",
                "(UTC+02:00) Africa/Kigali",
                "(UTC+01:00) Africa/Kinshasa",
                "(UTC+01:00) Africa/Lagos",
                "(UTC+01:00) Africa/Libreville",
                "(UTC+00:00) Africa/Lome",
                "(UTC+01:00) Africa/Luanda",
                "(UTC+02:00) Africa/Lubumbashi",
                "(UTC+02:00) Africa/Lusaka",
                "(UTC+01:00) Africa/Malabo",
                "(UTC+02:00) Africa/Maputo",
                "(UTC+02:00) Africa/Maseru",
                "(UTC+02:00) Africa/Mbabane",
                "(UTC+03:00) Africa/Mogadishu",
                "(UTC+00:00) Africa/Monrovia",
                "(UTC+03:00) Africa/Nairobi",
                "(UTC+01:00) Africa/Ndjamena",
                "(UTC+01:00) Africa/Niamey",
                "(UTC+00:00) Africa/Nouakchott",
                "(UTC+00:00) Africa/Ouagadougou",
                "(UTC+01:00) Africa/Porto-Novo",
                "(UTC+00:00) Africa/Sao_Tome",
                "(UTC+00:00) Africa/Timbuktu",
                "(UTC+02:00) Africa/Tripoli",
                "(UTC+01:00) Africa/Tunis",
                "(UTC+02:00) Africa/Windhoek",
                "(UTC-09:00) America/Adak",
                "(UTC-09:00) America/Anchorage",
                "(UTC-04:00) America/Anguilla",
                "(UTC-04:00) America/Antigua",
                "(UTC-03:00) America/Araguaina",
                "(UTC-03:00) America/Argentina/Buenos_Aires",
                "(UTC-03:00) America/Argentina/Catamarca",
                "(UTC-03:00) America/Argentina/ComodRivadavia",
                "(UTC-03:00) America/Argentina/Cordoba",
                "(UTC-03:00) America/Argentina/Jujuy",
                "(UTC-03:00) America/Argentina/La_Rioja",
                "(UTC-03:00) America/Argentina/Mendoza",
                "(UTC-03:00) America/Argentina/Rio_Gallegos",
                "(UTC-03:00) America/Argentina/Salta",
                "(UTC-03:00) America/Argentina/San_Juan",
                "(UTC-03:00) America/Argentina/San_Luis",
                "(UTC-03:00) America/Argentina/Tucuman",
                "(UTC-03:00) America/Argentina/Ushuaia",
                "(UTC-04:00) America/Aruba",
                "(UTC-04:00) America/Asuncion",
                "(UTC-05:00) America/Atikokan",
                "(UTC-10:00) America/Atka",
                "(UTC-03:00) America/Bahia",
                "(UTC-06:00) America/Bahia_Banderas",
                "(UTC-04:00) America/Barbados",
                "(UTC-03:00) America/Belem",
                "(UTC-06:00) America/Belize",
                "(UTC-04:00) America/Blanc-Sablon",
                "(UTC-04:00) America/Boa_Vista",
                "(UTC-05:00) America/Bogota",
                "(UTC-07:00) America/Boise",
                "(UTC-03:00) America/Buenos_Aires",
                "(UTC-07:00) America/Cambridge_Bay",
                "(UTC-04:00) America/Campo_Grande",
                "(UTC-05:00) America/Cancun",
                "(UTC-04:00) America/Caracas",
                "(UTC-03:00) America/Catamarca",
                "(UTC-03:00) America/Cayenne",
                "(UTC-05:00) America/Cayman",
                "(UTC-06:00) America/Chicago",
                "(UTC-06:00) America/Chihuahua",
                "(UTC-07:00) America/Ciudad_Juarez",
                "(UTC-05:00) America/Coral_Harbour",
                "(UTC-03:00) America/Cordoba",
                "(UTC-06:00) America/Costa_Rica",
                "(UTC-07:00) America/Creston"
        };

        for (final String timeZone : timeZones) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(timeZone)));
        }
    }

    public void checkChoicesForSubscriptionStatus() {
        final String[] options = {"Subscribed", "Unsubscribed", "Not Subscribed", "Reported as spam", "Bounced"};

        for (final String option : options) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(option)));
        }
    }

    public void checkChoicesForUnsubscribeReason() {
        final String[] options = {"I no longer want to receive emails from you", "I receive too many emails from you",
                "The emails are inappropriate", "The emails are spam", "Other unsubscribeReason"};

        for (final String option : options) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(option)));
        }
    }

    public void checkChoicesForSubscriptionTypes() {
        final String[] options = {"Newsletter", "Promotional", "Product updates", "Conference and events", "Non marketing emails from our company"};

        for (final String option : options) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(option)));
        }
    }

    public void checkSubscriptionStatus() {
        final String subscriptionStatus = "Subscription Status";
        final String fiveChoices = XPathBuilder.getXPathByText("5");
        String dependableFieldBlock = getDependableFieldBlock(subscriptionStatus);

        try {
            isDisplayed(findByXpath(dependableFieldBlock));

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(subscriptionStatus);
            isDisplayed(findByXpath(dependableFieldBlock));
        }

        final String subscriptionStatusBlock = getFieldBlock(subscriptionStatus);

        checkSpecificElement(subscriptionStatusBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(subscriptionStatusBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(subscriptionStatusBlock, fiveChoices)));
        checkChoicesForSubscriptionStatus();
        refresh();
        final String subscriptionTypes = getFieldBlock("Subscription Types");

        checkSpecificElement(subscriptionTypes, FieldTypePath.MULTI_SELECT);
        click(findByXpath(format(subscriptionTypes, fiveChoices)));
        checkChoicesForSubscriptionTypes();
        refresh();
        final String unsubscribeReason = getFieldBlock("Unsubscribe reason");

        checkSpecificElement(unsubscribeReason, FieldTypePath.DROPDOWN);
        click(findByXpath(format(unsubscribeReason, fiveChoices)));
        checkChoicesForUnsubscribeReason();
        refresh();
        final String otherUnsubscribeReason = getFieldBlock("Other unsubscribe reason");

        checkSpecificElement(otherUnsubscribeReason, FieldTypePath.LARGE_TEXT);

    }

    public void checkLifecycleStage() {
        final String lifecycleStage = "Lifecycle Stage";
        final String fourChoices = XPathBuilder.getXPathByText("4");
        final String lifecycleStageBlock = getFieldBlock(lifecycleStage);

        try {
            isDisplayed(findByXpath(getFieldBlock(lifecycleStage)));

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(lifecycleStage);
            isDisplayed(findByXpath(getFieldBlock(lifecycleStage)));
        }

        checkSpecificElement(lifecycleStageBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(lifecycleStageBlock, FieldTypePath.DROPDOWN);
        checkSpecificElement(lifecycleStageBlock, fourChoices);
    }

    public void checkSource() {
        final String source = "Source";
        final String fourteenChoices = XPathBuilder.getXPathByText("14");
        String sourceBlock = getFieldBlock(source);

        try {
            isDisplayed(findByXpath(sourceBlock));
        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(source);
            isDisplayed(findByXpath(sourceBlock));
        }

        checkSpecificElement(sourceBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(sourceBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(sourceBlock, fourteenChoices)));
        checkChoicesForSource();
    }

    public void checkTimezone() {
        final String timeZone = "Time Zone";
        final String hundredChoices = XPathBuilder.getXPathByText("100");
        String timezoneBlock = getFieldBlock(timeZone);

        try {
            isDisplayed(findByXpath(timezoneBlock));
        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(timeZone);
            isDisplayed(findByXpath(timezoneBlock));
        }

        checkSpecificElement(timezoneBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(timezoneBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(timezoneBlock, hundredChoices)));
        checkChoicesForSource();
    }

    public void isEnabled() {
        System.out.println(isEnabled(findByXpath(getPathOfSpecificCheckbox(getFieldBlock("First Name"), FieldElement.ADD_VIEW_CHECKBOX))));
        System.out.println(isEnabled(findByXpath(getPathOfSpecificCheckbox(getFieldBlock("Last Name"), FieldElement.ADD_VIEW_CHECKBOX))));
    }

    @Override
    protected List<Field> getDefaultFields() {
        return ContactField.getDefaultFields();
    }

    @Override
    protected Field[] getAllFields() {
        return ContactField.values();
    }

    @Override
    protected List<String> getMandatoryFields() {
        return Arrays.asList(
                getFirstNameDiv(),
                getLastNameDiv(),
                getEmailDiv(),
                getPhonesDiv(),
                getSalesOwnerDiv()
        );
    }

    @Override
    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getFirstNameDiv()) &&
                isNonDraggableIconDisplayed(getLastNameDiv()) &&
                isNonDraggableIconDisplayed(getPhonesDiv()) &&
                isNonDraggableIconDisplayed(getEmailDiv());
    }

    @Override
    protected List<Record> getDefaultSystemFieldElements() {
        return List.of(
                getFirstNameField(),
                getLastNameField(),
                getEmailsField(),
                getPhonesField(),
                getCompanyField(),
                getDesignationField(),
                getSalesOwnerField(),
                getFacebookField(),
                getLinkedInField()
        );
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        final List<Field> summaryDefaultFields = List.of(ContactField.EMAILS, ContactField.PHONES, ContactField.SALES_OWNER);

        for (final Field summaryDefaultField : summaryDefaultFields) {

            if (!isDisplayed(findByXpath(format("//*[@class='css-itno5t']",
                    XPathBuilder.getXPathByText(summaryDefaultField.getName()))))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uncheckMandatoryFields() {
        final String[] mandatoryFields = new String[]{
                getFirstNameDiv(),
                getEmailDiv(),
                getPhonesDiv(),
                getSalesOwnerDiv()
        };
        unCheck(mandatoryFields);

        return true;
    }
}

