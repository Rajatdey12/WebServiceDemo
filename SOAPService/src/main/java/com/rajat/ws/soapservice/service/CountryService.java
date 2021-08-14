package com.rajat.ws.soapservice.service;

import com.rajat.ws.soapservice.model.Country;
import com.rajat.ws.soapservice.model.Currency;
import com.rajat.ws.soapservice.model.GetCountryRequest;
import com.rajat.ws.soapservice.model.GetCountryResponse;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private static final String COUNTRY = "India";
    private static final String CAPITAL = "Delhi";

    public GetCountryResponse getCountryResponse(GetCountryRequest request) {

        GetCountryResponse response = new GetCountryResponse();
        Country country = new Country();

        if (request.getCountry().getName().equalsIgnoreCase(COUNTRY)
                && request.getCountry().getCapital().equalsIgnoreCase(CAPITAL)
                && request.getCountry().getCurrency().value().equalsIgnoreCase("INR")) {
            country.setCapital(CAPITAL);
            country.setCurrency(Currency.INR);
            country.setPopulation(600000);
            country.setName(COUNTRY);

        } else if(request.getCountry().getName().equalsIgnoreCase("U.S.A")
                && request.getCountry().getCapital().equalsIgnoreCase("Washington D.C")
                && request.getCountry().getCurrency().value().equalsIgnoreCase("DOLLAR")){
            country.setCapital("Washington D.C");
            country.setCurrency(Currency.DOLLAR);
            country.setPopulation(200000);
            country.setName("U.S.A");

        } else {
            country.setCapital("No country capital Info");
            country.setCurrency(Currency.NONE);
            country.setPopulation(0);
            country.setName("No Country name Info");
        }
        response.setCountry(country);

        return response;
    }
}

