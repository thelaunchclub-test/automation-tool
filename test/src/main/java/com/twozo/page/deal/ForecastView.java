package com.twozo.page.deal;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class ForecastView extends Deal{

    private static ForecastView forecastView;

    public ForecastView() {
        super();
    }

    public static ForecastView getInstance(){

     //   if (Objects.isNull(forecastView)) {
            forecastView = new ForecastView();
       // }

        return forecastView;
    }
}
