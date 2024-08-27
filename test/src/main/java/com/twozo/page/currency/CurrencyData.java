package com.twozo.page.currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyData {

    private String currencyName;
    private int decimal;
    private boolean isBase;
    private boolean isDefault;
    private boolean isPopUpVisible;
    private boolean isAddCurrency;
    private boolean isEnable;
    private boolean isListView;
}
