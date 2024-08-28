package com.twozo.page.company;

import com.twozo.web.driver.service.WebAutomationDriver;

public class AddCompany extends Company {

    private static AddCompany addCompany;

    protected AddCompany() {
        super();
    }

    public static AddCompany getInstance() {

       // if (Objects.isNull(addCompany)) {
            addCompany = new AddCompany();
        //}

        return addCompany;
    }
}
