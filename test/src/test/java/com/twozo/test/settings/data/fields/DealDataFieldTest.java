package com.twozo.test.settings.data.fields;

import com.twozo.page.settings.data.fields.deal.DealDataField;
import com.twozo.test.settings.SettingsTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DealDataFieldTest extends SettingsTest {

    DealDataField deal;

    @BeforeClass
    public void initialize() {
        deal = settings.switchToDealDataFields();
    }

    @Test
    public void verifySelectedTabIsActive() {
        deal.verifyActiveDealTab();
    }
}
