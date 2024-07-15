package com.twozo.page.settings.data.fields.contact;

import com.twozo.page.settings.data.fields.field.Field;

public enum ContactSystemField implements Field {

    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    EMAILS("Emails"),
    PHONES("Phones"),
    DESIGNATION("Designation"),
    COMPANY("Company"),
    SALES_OWNER("Sales Owner"),
    FACEBOOK("Facebook"),
    LINKED_IN("LinkedIn"),
    LIFECYCLE_STAGE("Lifecycle Stage"),
    SOURCE("Source"),
    TERRITORY("Territory"),
    TAGS("Tags"),
    DATE_OF_BIRTH("Date Of Birth"),
    DEPARTMENT("Department"),
    ADDRESS("Address"),
    TWITTER("Twitter"),
    SUBSCRIPTION_STATUS("Subscription Status"),
    SUBSCRIPTION_TYPES("Subscription Types"),
    UNSUBSCRIBE_REASON("Unsubscribe reason"),
    OTHER_UNSUBSCRIBE_REASON("Other unsubscribe reason"),
    WEB_FORM("Web Form");

    private final String name;

    ContactSystemField(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
