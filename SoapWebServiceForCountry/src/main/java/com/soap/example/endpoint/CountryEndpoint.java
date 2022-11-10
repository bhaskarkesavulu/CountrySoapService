package com.soap.example.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.web.consumer.stub.GetCountryRequest;
import com.web.consumer.stub.GetCountryResponse;

@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";
	Logger logger = LoggerFactory.getLogger(CountryEndpoint.class);

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        logger.info("Country is " + request.getName());
        logger.info("Response is : " + response);

        return response;
    }
}
