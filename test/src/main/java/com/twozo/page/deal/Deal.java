package com.twozo.page.deal;

import com.twozo.page.BasePage;
import com.twozo.page.contact.Contact;
import com.twozo.page.Filter;
import com.twozo.page.homepage.HomePage;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class Deal extends BasePage {

    private static Deal deal;

    private AddDeal addDeal;
    private KanbanView kanbanView;
    private ForecastView forecastView;
    private Filter filter;
    private WebPageElement signInButton;
    private WebPageElement newDeal;
    private WebPageElement wonDeal;
    private WebPageElement lostDeal;
    private WebPageElement general;
    private WebPageElement allDeal;
    private WebPageElement importDeals;
    private WebPageElement addDealButton;
    private WebPageElement kanbanViewButton;
    private WebPageElement listViewButton;
    private WebPageElement forecastViewButton;
    private WebPageElement contactIcon;
    private WebPageElement filterIcon;

    public Deal(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        //click(getSignInButton());
//        System.out.println(pageInformationProvider.getCurrentUrl());
//        if(!pageInformationProvider.getCurrentUrl().equals("https://app.thelaunchclub.in/deals")){
//            throw TestException.get(WebDriverStatusCode.EXPECTED_PAGE_NOT_FOUND);
        //}
    }

    public static Deal getInstance(final WebAutomationDriver webAutomationDriver) {

      //  if (Objects.isNull(deal)) {
            deal = new Deal(webAutomationDriver);
        //}

        return deal;
    }

    public AddDeal getAddDeal() {

        if (Objects.isNull(addDeal)) {
            addDeal = AddDeal.getInstance(webAutomationDriver);

        }

        return addDeal;
    }

    public KanbanView getKanbanView() {

        if (Objects.isNull(kanbanView)) {
            kanbanView = KanbanView.getInstance(webAutomationDriver);

        }

        return kanbanView;
    }

    public ForecastView getForecastView() {

        if (Objects.isNull(addDeal)) {
            forecastView = ForecastView.getInstance(webAutomationDriver);

        }

        return forecastView;
    }

    public Filter getFilter() {

        if (Objects.isNull(filter)) {
            filter = Filter.getInstance(webAutomationDriver);

        }

        return filter;
    }

    public WebPageElement getNewDeal() {

        if (Objects.isNull(newDeal)) {
            newDeal = findByText("New");

        }

        return newDeal;
    }

    public WebPageElement getSignInButton() {

        if (Objects.isNull(signInButton)) {
            signInButton = findByText("Sign In");
        }

        return signInButton;
    }

    public WebPageElement getWonDeal() {

        if (Objects.isNull(wonDeal)) {
            wonDeal = findByText("Won");
        }

        return wonDeal;
    }

    public WebPageElement getLostDeal() {

        if (Objects.isNull(lostDeal)) {
            lostDeal = findByText("Lost");
        }

        return lostDeal;
    }

    public WebPageElement getGeneral() {

        if (Objects.isNull(general)) {
            general = findByText("General");
        }

        return general;
    }

    public WebPageElement getAllDeal() {

        if (Objects.isNull(allDeal)) {
            allDeal = findByText("All Deal");
        }

        return allDeal;
    }

    public WebPageElement getImportDeals() {

        if (Objects.isNull(importDeals)) {
            importDeals = findByText("Import Deals");
        }

        return importDeals;
    }

    public WebPageElement getAddDealButton() {

        if (Objects.isNull(addDealButton)) {
            addDealButton = findByXpath("//*[text()='Deal'][@type='button']");
        }

        return addDealButton;
    }

    public WebPageElement getKanbanViewButton() {

        if (Objects.isNull(kanbanViewButton)) {
            kanbanViewButton = findByText("kanban");
        }

        return kanbanViewButton;
    }

    public WebPageElement getListViewButton() {

        if (Objects.isNull(listViewButton)) {
            listViewButton = findByText("list");
        }

        return listViewButton;
    }

    public WebPageElement getForecastViewButton() {

        if (Objects.isNull(forecastViewButton)) {
            forecastViewButton = findByText("forecast");
        }

        return forecastViewButton;
    }

    public WebPageElement getContactIcon() {

        if (Objects.isNull(contactIcon)) {
            contactIcon = findByXpath("(//*[@class='MuiListItem-root MuiListItem-gutters css-12dzmul'])[2]");
        }

        return contactIcon;
    }

    public WebPageElement getFilterIcon() {

        if (Objects.isNull(filterIcon)) {
            filterIcon = findByXpath("//div[@class='css-j7qwjs'][@style='cursor: pointer;']");
        }

        return filterIcon;
    }

    public AddDeal switchToAddDeal() {
        click(getAddDealButton());

        return getAddDeal();
    }

    public ForecastView switchToForecastView() {
        click(getForecastViewButton());

        return getForecastView();
    }

    public KanbanView switchToKanbanView() {
        click(getKanbanViewButton());

        return getKanbanView();
    }

    public Filter switchToclickFilter() {
        click(getFilterIcon());

        return getFilter();
    }

    public Contact switchToContact() {
        return HomePage.getInstance(webAutomationDriver).switchToContact();
    }
}
