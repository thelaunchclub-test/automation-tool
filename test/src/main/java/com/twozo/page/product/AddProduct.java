package com.twozo.page.product;

import com.twozo.page.activity.AddActivity;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class AddProduct extends Product{

    private static AddProduct addProduct;

    protected AddProduct() {
        super();
    }

    public static AddProduct getInstance() {

//        if (Objects.isNull(addProduct)) {

            addProduct = new AddProduct();
  //      }

        return addProduct;
    }
}
