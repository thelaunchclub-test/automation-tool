package com.twozo.page.product;

import com.twozo.page.activity.AddActivity;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class AddProduct extends Product{

    private static AddProduct addProduct;

    protected AddProduct(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static AddProduct getInstance(final WebAutomationDriver webAutomationDriver) {

//        if (Objects.isNull(addProduct)) {

            addProduct = new AddProduct(webAutomationDriver);
  //      }

        return addProduct;
    }
}
