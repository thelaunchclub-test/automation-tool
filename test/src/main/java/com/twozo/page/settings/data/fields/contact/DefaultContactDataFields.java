package com.twozo.page.settings.data.fields.contact;

import com.twozo.page.settings.data.fields.field.Field;

public enum DefaultContactDataFields implements Field {
    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    EMAILS("Emails"),
    PHONES("Phones"),
    DESIGNATION("Designation"),
    COMPANY("Company"),
    SALES_OWNER("Sales Owner"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter");

    private final String name;

    DefaultContactDataFields(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
