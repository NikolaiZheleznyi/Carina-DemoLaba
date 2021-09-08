package com.qaprosoft.carina.demo.openWheather;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.crypto.CryptoConsole;
import com.qaprosoft.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class APIOpenWeatherTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "nzheleznyi")
    public void testGetCurrentWeather() {
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        CryptoConsole cryptoConsole = new CryptoConsole();
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        //getWeatherMethod.addParameter("appId", "bd00dc2b6528344b42416f4bbb5a9563");
        getWeatherMethod.addParameter("q", "Minsk");
        getWeatherMethod.callAPI();
        getWeatherMethod.validateResponseAgainstSchema("api/users/openWeather_get/rs.schema");
        getWeatherMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nzheleznyi")
    public void testGetForecastWeather() {
        GetForecastWeatherMethod getForecastWeatherMethod = new GetForecastWeatherMethod();
        getForecastWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        //getForecastWeatherMethod.addParameter("appId", "bd00dc2b6528344b42416f4bbb5a9563");
        getForecastWeatherMethod.addParameter("lat", "53.9");
        getForecastWeatherMethod.addParameter("lon", "27.5667");
        getForecastWeatherMethod.addParameter("exclude", "hourly,daily");
        getForecastWeatherMethod.callAPI();
        getForecastWeatherMethod.validateResponseAgainstSchema("api/users/forecast_get/rs.schema");
        getForecastWeatherMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nzheleznyi")
    public void testGet5dayForecast() {
        Get5DayForecastMethod get5DayForecastMethod = new Get5DayForecastMethod();
        get5DayForecastMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        //get5DayForecastMethod.addParameter("appId", "bd00dc2b6528344b42416f4bbb5a9563");
        get5DayForecastMethod.addParameter("q", "Minsk");
        get5DayForecastMethod.callAPI();
        get5DayForecastMethod.validateResponseAgainstSchema("api/users/5dayForecast_get/rs.schema");
        //get5DayForecastMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nzheleznyi")
    public void testGetDirectGeocoding() {
        GetDirectGeocodingMethod getDirectGeocodingMethod = new GetDirectGeocodingMethod();
        getDirectGeocodingMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        //getDirectGeocodingMethod.addParameter("appId", "bd00dc2b6528344b42416f4bbb5a9563");
        getDirectGeocodingMethod.addParameter("q", "Minsk");
        getDirectGeocodingMethod.addParameter("limit", "5");
        getDirectGeocodingMethod.callAPI();
        getDirectGeocodingMethod.validateResponseAgainstSchema("api/users/directGeocoding_get/rs.schema");
        getDirectGeocodingMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nzheleznyi")
    public void testGetAirPollution() {
       GetAirPollutionMethod getAirPollutionMethod = new GetAirPollutionMethod();
        getAirPollutionMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        //getAirPollutionMethod.addParameter("appId", "bd00dc2b6528344b42416f4bbb5a9563");
        getAirPollutionMethod.addParameter("lat", "53.9");
        getAirPollutionMethod.addParameter("lon", "27.5667");
        getAirPollutionMethod.callAPI();
        getAirPollutionMethod.validateResponseAgainstSchema("api/users/airPollution_get/rs.schema");
        getAirPollutionMethod.validateResponse();
    }
}
