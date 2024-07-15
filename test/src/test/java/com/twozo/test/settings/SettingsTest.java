package com.twozo.test.settings;

import com.twozo.page.settings.data.fields.contact.Contact;
import com.twozo.page.settings.data.fields.contact.ContactSystemField;
import com.twozo.page.settings.data.fields.contact.DefaultContactDataFields;
import com.twozo.test.BaseTest;
import com.twozo.test.sign.in.SignInTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(SignInTest.class);

    @Test
    public void checkSystemFields() {
        signIn.signIn("aio@gmail.com", "A$12345a").switchToSettings().switchToContact().
                checkSystemFields();
        LOG.info("The default system fields are displayed");
    }

    @Test
    public void addSystemFields() {
        Contact contact = signIn.signIn("sandra@gmail.com", "A$12345a").switchToSettings().switchToContact();
        contact.addSystemField(ContactSystemField.TERRITORY.getName());
        //Assert.assertTrue(contact.isDisplayed(contact.getMenuBlock(contact.findByXpath())));
        LOG.info("Added system field successfully");
    }

    @Test
    public void addAllSystemFields() {
        final Contact contact = signIn.signIn("ag@gmail.com", "A$12345a").switchToSettings().switchToContact();
        contact.checkSystemFieldsFieldType();
    }

    @Test
    public void addCustomField() {
        signIn.signIn("yung@gmail.com", "A$12345a").switchToSettings().switchToContact().
                addCustomField("test", "Text");
        LOG.info("Added custom field successfully");
    }

    @Test
    public void checkAllFieldTypes() {
        Contact contact = signIn.signIn("aghd@gmail.com", "A$12345a").switchToSettings().switchToContact();
        contact.checkSystemFieldsFieldType();
        LOG.info("Added custom field successfully");
    }

    @Test
    public void checkEyeIcon() {
        Contact contact = signIn.signIn("iii@gmail.com", "A$12345a").switchToSettings().switchToContact();
        //contact.checkEyeIcon(DefaultContactDataFields.values());

        contact.cancel();
        //LOG.info("Added custom field successfully");
    }

}
