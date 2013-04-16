package com.enonic.soapclient;

import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherSoap;
import org.jdom.Document;
import org.jdom.Element;
import java.util.logging.Logger;

public class SoapClient {
    Logger log = Logger.getLogger("SoapClient");

    public Document GetWeather() {
        Element ele = new Element("weather-types");
        Weather weatherService = new Weather();
        WeatherSoap weatherSoap = weatherService.getWeatherSoap();
        ForecastReturn forecastReturn = weatherSoap.getCityForecastByZIP("94025");
        log.info(forecastReturn.getCity());
        log.info("Processing response..");

        ele.addContent(new Element("city").setText(forecastReturn.getCity()));
        return new Document(ele);
    }

}