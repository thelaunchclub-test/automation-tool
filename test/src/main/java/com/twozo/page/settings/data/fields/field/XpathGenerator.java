package com.twozo.page.settings.data.fields.field;

import com.twozo.page.BasePage;
import com.twozo.web.driver.service.WebAutomationDriver;

public class XpathGenerator extends BasePage {

    protected XpathGenerator(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public String getFieldBlock(Field field) {

        int rowNumber = 1;
        String xpath = "((//*[@class='css-11x1d9z'])[%d]/div/div/div/p)[1]";

        while (!field.getName().equals(getText(findByXpath(String.format(xpath, rowNumber))))) {
            rowNumber++;
        }

        return String.format("(//*[@class='css-11x1d9z'])[%d]", rowNumber);
    }

    public String getMenuBlock(final String  fieldName) {

        int rowNumber = 1;
        String xpath = "(//*[@class='css-u4p24i'])[%d]";

        while (!fieldName.equals(getText(findByXpath(String.format(xpath, rowNumber))))) {
            rowNumber++;
        }

        return String.format("(//*[@class='css-u4p24i'])[%d]", rowNumber);
    }
}
