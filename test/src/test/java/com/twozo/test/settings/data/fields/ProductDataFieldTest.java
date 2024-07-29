package com.twozo.test.settings.data.fields;

import com.twozo.page.settings.data.fields.product.ProductDataField;
import com.twozo.test.settings.SettingsTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDataFieldTest extends SettingsTest {

    ProductDataField product;

    @BeforeClass
    public void initialize() {
        product = settings.switchToProductDataFields();
    }

    @Test
    public void verifySelectedTabIsActive() {
        product.verifyActiveProductTab();
    }
}
