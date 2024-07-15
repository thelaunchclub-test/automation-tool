package com.twozo.page.settings.data.fields.field;

public enum CommonAutoGeneratingFields implements Field {

    ID("Id"),
    UPDATED_BY("Updated By"),
    CREATED_AT("Created At"),
    RECENT_NOTE("Recent Note"),
    CREATED_BY("Created By"),
    UPDATED_AT("Updated At"),
    LAST_ASSIGNED_AT("Last Assigned At"),
    LAST_ACTIVITY_DATE("Last Activity Date"),
    NEXT_ACTIVITY_DATE("Next Activity Date"),
    LAST_EMAIL_RECEIVED("Last Email Received"),
    LAST_EMAIL_SENT("Last Email Sent"),
    TIME_ZONE("Time Zone"),
    OPEN_DEALS("Open Deals"),
    CLOSED_DEALS("Closed Deals"),
    WON_DEALS("Won Deals"),
    LOST_DEALS("Lost Deals"),
    LAST_ACTIVITY_TYPE("Last Activity Type"),
    DONE_ACTIVITIES("Done Activities"),
    UPCOMING_ACTIVITIES("Upcoming Activities"),
    TOTAL_ACTIVITIES("Total Activities"),
    EMAIL_MESSAGES_COUNT("Email Message Count");


    private final String name;

    CommonAutoGeneratingFields(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
