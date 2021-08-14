package com.rajat.ws.soapservice.endpoint;

import com.rajat.ws.soapservice.model.GetCountryRequest;
import com.rajat.ws.soapservice.model.GetCountryResponse;
import com.rajat.ws.soapservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE = "http://www.rajat.com/ws/SOAPService/model";

    @Autowired
    private CountryService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        return service.getCountryResponse(request);
    }
}
