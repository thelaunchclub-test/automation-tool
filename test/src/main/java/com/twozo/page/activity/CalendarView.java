package com.twozo.page.activity;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class CalendarView extends Activity {

    private static CalendarView calendarView;

    protected CalendarView() {
        super();
    }

    public static CalendarView getInstance() {

      //  if (Objects.isNull(calendarView)) {

            calendarView = new CalendarView();
        //}

        return calendarView;
    }
}
