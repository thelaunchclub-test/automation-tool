package com.twozo.page.company;

import com.twozo.page.contact.AddContact;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class AddCompany extends Company {

    private static AddCompany addCompany;

    protected AddCompany(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static AddCompany getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(addCompany)) {
            addCompany = new AddCompany(webAutomationDriver);
        }

        return addCompany;
    }
}
