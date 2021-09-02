package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.demo.utils.CryptoPassword;

import java.util.Properties;

public class GetForecastWeatherMethod extends AbstractApiMethodV2 {
    public GetForecastWeatherMethod() {
        super(null, "api/users/forecast_get/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appId", CryptoPassword.getApiKey());
    }
}