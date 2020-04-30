package com.example.mapbuddybackend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {

	private final RestTemplate restTemplate;
	private final HttpHeaders headers;

	@Autowired
	private Environment env;


	public BusinessService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		this.headers = new HttpHeaders();
	}

	public String formatBusinessForUrl(String bus) {
		StringBuilder url = new StringBuilder("?term=");
		System.out.println("lol wtf");
		bus.replace(" ", "+");
		url.append(bus);
		return url.toString();
	}

	public String formatLocationForUrl(String loc) {
		StringBuilder url = new StringBuilder("&location=");
		loc.replace(" ", "+");
		url.append(loc);
		return url.toString();
	}

	BusinessList getAllBusinessesFromUrl(String url) {
		System.out.println(url);
		String apiKey = "Bearer " + env.getProperty("yelp.api.key");

		// set the api key
		headers.set("Authorization", apiKey);

		// build the request
		HttpEntity request = new HttpEntity(headers);

		// use `exchange` method for HTTP call
		ResponseEntity<BusinessList> response = this.restTemplate.exchange(url.toString(), HttpMethod.GET, request, BusinessList.class, 1);

		if (response.getStatusCode() == HttpStatus.OK) {
			BusinessList bl = response.getBody();
			//bl.printAllBusinesses();
			return bl;

		} else {
			return null;
		}

	}

	BusinessList filterOutBusinesses(BusinessList bl, String businessName) {
		List<Business> businessList = bl.getBusinesses();
		List<Business> newBusinessList = new ArrayList<Business>();


		String s2 = businessName;
		s2 = s2.replaceAll("[^a-zA-Z0-9]", "");

		for (int i = 0; i < businessList.size(); i++) {

			String s1 = businessList.get(i).getName();
			s1 = s1.replaceAll("[^a-zA-Z0-9]", "");

			if (s1.equalsIgnoreCase(s2)) {
				newBusinessList.add(businessList.get(i));
			}

		}
		bl.setBusinesses(newBusinessList);
		System.out.println("-----------------------");
		bl.printAllBusinesses();
		bl.printAllBusinessLongAndLat();
		return bl;
	}

	public BusinessList getBusinessListWithCustomHeaders(String location, List<String> businessNames) {


		StringBuilder url = new StringBuilder( "https://api.yelp.com/v3/businesses/search");
		BusinessList bl = new BusinessList();
		for (int i = 0; i < businessNames.size(); i++) {
			url = new StringBuilder("https://api.yelp.com/v3/businesses/search");
			String formattedBusiness = formatBusinessForUrl(businessNames.get(i));
			url.append(formattedBusiness);
			String formattedLocation = formatLocationForUrl(location);
			url.append(formattedLocation);

			bl = getAllBusinessesFromUrl(url.toString());
			bl = filterOutBusinesses(bl, businessNames.get(i));

		}

		return bl;
	}

}
