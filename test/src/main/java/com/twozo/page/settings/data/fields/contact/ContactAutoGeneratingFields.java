package com.twozo.page.settings.data.fields.contact;

import com.twozo.page.settings.data.fields.field.Field;

public enum ContactAutoGeneratingFields implements Field {

    TIME_ZONE("Time Zone"),
    RECENT_NOTE("Recent Note"),
    OPEN_DEALS("Open Deals"),
    CLOSED_DEALS("Closed Deals"),
    WON_DEALS("Won Deals"),
    LOST_DEALS("Lost Deals"),
    LAST_ACTIVITY_DATE("Last Activity Date"),
    NEXT_ACTIVITY_DATE("Next Activity Date"),
    LAST_ACTIVITY_TYPE("Last Activity Type"),
    DONE_ACTIVITIES("Done Activities"),
    UPCOMING_ACTIVITIES("Upcoming Activities"),
    TOTAL_ACTIVITIES("Total Activities"),
    EMAIL_MESSAGES_COUNT("Email Messages Count"),
    LAST_EMAIL_RECEIVED("Last Email Received"),
    LAST_EMAIL_SENT("Last Email Sent");

    private final String name;

    ContactAutoGeneratingFields(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
