package com.twozo.page.activity;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class CalendarView extends Activity {

    private static CalendarView calendarView;

    protected CalendarView(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    public static CalendarView getInstance(final WebAutomationDriver webAutomationDriver) {

      //  if (Objects.isNull(calendarView)) {

            calendarView = new CalendarView(webAutomationDriver);
        //}

        return calendarView;
    }
}
