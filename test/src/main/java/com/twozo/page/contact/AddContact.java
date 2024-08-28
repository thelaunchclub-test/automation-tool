package com.twozo.page.contact;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class AddContact extends Contact {

    private static AddContact addContact;

    protected AddContact() {
        super();
    }

    public static AddContact getInstance() {

       // if (Objects.isNull(addContact)) {
            addContact = new AddContact();
        //}

        return addContact;
    }
}
