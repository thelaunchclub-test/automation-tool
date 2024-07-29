package com.twozo.test.settings;

import com.twozo.page.contact.Contact;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.contact.ContactDataField;
import com.twozo.test.BaseTest;

import org.testng.annotations.BeforeClass;

public class SettingsTest extends BaseTest {

    // private static final Logger LOG = LoggerFactory.getLogger(SignInTest.class);

    protected HomePage homePage;
    protected Settings settings;
    protected ContactDataField contactDataField;
    //protected Contact contact = homePage.switchToContact();

    @BeforeClass
    public void initialize() {
        homePage = signIn.signIn("jade@gmail.com", "A$12345a");
        contactDataField = homePage.switchToSettings().switchToContactDataFields();
    }
}
