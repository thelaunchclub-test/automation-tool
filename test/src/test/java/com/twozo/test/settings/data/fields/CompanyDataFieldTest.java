package com.twozo.test.settings.data.fields;

import com.twozo.page.settings.data.fields.company.Company;
import com.twozo.test.settings.SettingsTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompanyDataFieldTest extends SettingsTest {

    Company company;

    @BeforeClass
    public void initialize() {
        company = settings.switchToCompanyDataFields();
    }

    @Test
    public void verifySelectedTabIsActive() {
        company.verifyActiveCompanyTab();
    }
}
