package com.twozo.page.settings;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.BasePage;
import com.twozo.page.settings.data.fields.company.Company;
import com.twozo.page.settings.data.fields.contact.Contact;
import com.twozo.page.settings.data.fields.deal.Deal;
import com.twozo.page.settings.data.fields.product.Product;
import com.twozo.page.url.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Settings extends BasePage {

    private static Settings settings;

    private WebPageElement contact;
    private WebPageElement company;
    private WebPageElement deal;
    private WebPageElement product;
    private Collection<WebPageElement> fields;

    protected Settings(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        if (getURL().equals(URL.SETTINGS)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static Settings getInstance(final WebAutomationDriver webAutomationDriver) {

        //   if (Objects.isNull(settings)) {
        settings = new Settings(webAutomationDriver);
        // }

        return settings;
    }

    public WebPageElement getContact() {

        if (Objects.isNull(contact)) {
            contact = findByText("Contact");
        }

        return contact;
    }

    public WebPageElement getCompany() {

        if (Objects.isNull(company)) {
            company = findByText("Company");
        }

        return company;
    }

    public WebPageElement getDeal() {

        if (Objects.isNull(deal)) {
            deal = findByText("Deal");
        }

        return deal;
    }

    public WebPageElement getProduct() {

        if (Objects.isNull(product)) {
            product = findByText("Product");
        }

        return product;
    }

    private Collection<WebPageElement> getFields() {

        if (Objects.isNull(fields)) {
            fields = findElementsByXpath("//*[@data-rbd-droppable-id='field-list']/div/div/div/div/div/div[2]/div/p");
        }

        return fields;
    }

    public Collection<String> getFieldNames(final Source source) {
       // click(findByText(source.getName()));
        final List fields = new ArrayList();

        for (WebPageElement field : getFields()) {
            fields.add(getText(field));
        }

        return getTexts(getFields());
    }

    public Contact switchToContactDataFields() {
        click(getContact());

        return Contact.getInstance(webAutomationDriver);
    }

    public Company switchToCompanyDataFields() {
        click(getCompany());

        return Company.getInstance(webAutomationDriver);
    }

    public Deal switchToDealDataFields() {
        click(getContact());

        return Deal.getInstance(webAutomationDriver);
    }

    public Product switchToProductDataFields() {
        click(getProduct());

        return Product.getInstance(webAutomationDriver);
    }

//    public void check() {
//        click(findBelowElement(List.of(new Element(LocatorType.XPATH, "//*[text()='Email Sync']", true),
//                new Element(LocatorType.TAG_NAME, "p", false))));
//    }
}
