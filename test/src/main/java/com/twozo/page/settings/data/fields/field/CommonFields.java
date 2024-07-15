package com.twozo.page.settings.data.fields.field;

public enum CommonFields implements Field{

    TAGS("Tags"),
    SALES_OWNER("Sales Owner"),
    SOURCE("Source"),
    TERRITORY("Territory");

    private final String name;

    CommonFields(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
