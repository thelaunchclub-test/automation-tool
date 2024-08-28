package com.twozo.page.inbox;

import com.twozo.page.BasePage;
import com.twozo.page.analytics.Analytics;
import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class Inbox extends BasePage {

    private static Inbox inbox;

    protected Inbox() {
        super();
    }

    public static Inbox getInstance() {

       // if (Objects.isNull(inbox)) {
            inbox = new Inbox();
        //}

        return inbox;
    }
}
