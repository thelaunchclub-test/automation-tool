package com.twozo.page.contact;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class AddContact extends Contact {

    private static AddContact addContact;

    protected AddContact(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static AddContact getInstance(final WebAutomationDriver webAutomationDriver) {

       // if (Objects.isNull(addContact)) {
            addContact = new AddContact(webAutomationDriver);
        //}

        return addContact;
    }
}
