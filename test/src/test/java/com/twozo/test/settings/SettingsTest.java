package com.twozo.test.settings;

import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.company.CompanyDataField;
import com.twozo.page.settings.data.fields.contact.ContactDataField;
import com.twozo.page.settings.data.fields.deal.DealDataField;
import com.twozo.page.settings.data.fields.product.ProductDataField;
import com.twozo.test.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    // private static final Logger LOG = LoggerFactory.getLogger(SignInTest.class);

    protected HomePage homePage;
    protected Settings settings;
    protected ContactDataField contactDataField;
    protected CompanyDataField companyDataField;
    protected DealDataField dealDataField;
    protected ProductDataField productDataField;

    @BeforeClass
    public void initialize() {
        homePage = signIn.signIn("jd@gmail.com", "A$12345a");
        contactDataField = homePage.switchToSettings().switchToContactDataFields();

        //companyDataField = homePage.switchToSettings().switchToCompanyDataFields();
        // dealDataField = homePage.switchToSettings().switchToDealDataFields();
        //productDataField = homePage.switchToSettings().switchToProductDataFields();

    }
}
