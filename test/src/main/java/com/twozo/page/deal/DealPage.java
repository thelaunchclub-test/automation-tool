package com.twozo.page.deal;

import com.twozo.page.BasePage;
import com.twozo.page.contact.Contact;
import com.twozo.page.Filter;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class DealPage extends BasePage {

    private static DealPage dealPage;

    private WebPageElement signInButton;
    private WebPageElement newDeal;
    private WebPageElement wonDeal;
    private WebPageElement lostDeal;
    private WebPageElement general;
    private WebPageElement allDeal;
    private WebPageElement importDeals;
    private WebPageElement addDeal;
    private WebPageElement kanbanView;
    private WebPageElement listView;
    private WebPageElement forecastView;
    private WebPageElement contactIcon;
    private WebPageElement filterIcon;

    public DealPage(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        //click(getSignInButton());
//        System.out.println(pageInformationProvider.getCurrentUrl());
//        if(!pageInformationProvider.getCurrentUrl().equals("https://app.thelaunchclub.in/deals")){
//            throw TestException.get(WebDriverStatusCode.EXPECTED_PAGE_NOT_FOUND);
        //}
    }

    public static synchronized DealPage getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(dealPage)) {
            dealPage = new DealPage(webAutomationDriver);
        }

        return dealPage;
    }

    private WebPageElement findElementWith(final String value) {
        final String xpath = "//*[text()='%s']";
        return findElement(new Finder(LocatorType.XPATH, String.format(xpath, value), true));
    }

    public WebPageElement getNewDeal() {
        if (Objects.isNull(newDeal)) {
            newDeal = findElementWith("New");
        }
        return newDeal;
    }

    public WebPageElement getSignInButton() {
        if (Objects.isNull(signInButton)) {
            signInButton = findElementWith("Sign In");
        }
        return signInButton;
    }

    public WebPageElement getWonDeal() {
        if (Objects.isNull(wonDeal)) {
            wonDeal = findElementWith("Won");
        }
        return wonDeal;
    }

    public WebPageElement getLostDeal() {
        if (Objects.isNull(lostDeal)) {
            lostDeal = findElementWith("Lost");
        }
        return lostDeal;
    }

    public WebPageElement getGeneral() {
        if (Objects.isNull(general)) {
            general = findElementWith("General");
        }
        return general;
    }

    public WebPageElement getAllDeal() {
        if (Objects.isNull(allDeal)) {
            allDeal = findElementWith("All Deal");
        }
        return allDeal;
    }

    public WebPageElement getImportDeals() {
        if (Objects.isNull(importDeals)) {
            importDeals = findElementWith("Import Deals");
        }
        return importDeals;
    }

    public WebPageElement getAddDeal() {
        if (Objects.isNull(addDeal)) {
            addDeal = findElement(new Finder(LocatorType.XPATH, "//*[text()='Deal'][@type='button']", true));
        }
        return addDeal;
    }

    public WebPageElement getKanbanView() {
        if (Objects.isNull(kanbanView)) {
            kanbanView = findElementWith("kanban");
        }
        return kanbanView;
    }

    public WebPageElement getListView() {
        if (Objects.isNull(listView)) {
            listView = findElementWith("list");
        }
        return listView;
    }

    public WebPageElement getForecastView() {
        if (Objects.isNull(forecastView)) {
            forecastView = findElementWith("forecast");
        }
        return forecastView;
    }

    public WebPageElement getContactIcon() {
        if (Objects.isNull(contactIcon)) {
            contactIcon = findElement(new Finder(LocatorType.XPATH,
                    "(//*[@class='MuiListItem-root MuiListItem-gutters css-12dzmul'])[2]", true));
        }
        return contactIcon;
    }

    public WebPageElement getFilterIcon() {
        if (Objects.isNull(filterIcon)) {
            filterIcon = findElement(new Finder(LocatorType.XPATH, "//div[@class='css-j7qwjs'][@style='cursor: pointer;']", true));
        }
        return filterIcon;
    }

    public void check() {
        click(getGeneral());
        select("dummy");
    }

    public AddDeal clickAddDeal() {
        click(getAddDeal());
        return AddDeal.getInstance(webAutomationDriver);
    }

    public Filter applyFilter(){
        click(getFilterIcon());
        return Filter.getInstance(webAutomationDriver);
    }

    public Contact switchToContact() {
        click(getContactIcon());
        return Contact.getInstance(webAutomationDriver);
    }
}
