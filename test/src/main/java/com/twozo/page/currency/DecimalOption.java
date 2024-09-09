package com.twozo.page.currency;

import lombok.Getter;

@Getter
public enum DecimalOption {
    NO_DECIMAL(0, "No Decimals"),
    ONE_DECIMAL(1, "One decimal"),
    TWO_DECIMALS(2, "Two decimals"),
    THREE_DECIMALS(3, "Three decimals"),
    FOUR_DECIMALS(4, "Four decimals");

    private final int value;
    private final String description;

    DecimalOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static DecimalOption fromValue(int value) {
        for (DecimalOption option : DecimalOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid decimal value: " + value);
    }

    public static DecimalOption fromDescription(String description) {
        for (DecimalOption option : DecimalOption.values()) {
            if (option.getDescription().equalsIgnoreCase(description)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid decimal description: " + description);
    }
}


