package com.example.mapbuddybackend.business;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class BusinessList {

	private static BusinessList single_instance = null;

	private List<Business> businesses;

	public BusinessList() {
		businesses = new ArrayList<>();
	}

	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

	public void printAllBusinesses() {
		for (int i = 0; i < businesses.size(); i++) {
			System.out.println(businesses.get(i).getName());
		}
	}
	public void printAllBusinessLongAndLat() {
		for (int i = 0; i < businesses.size(); i++) {
			System.out.println("Long: " + businesses.get(i).getCoordinates().getLongitude());
			System.out.println("Lat: " + businesses.get(i).getCoordinates().getLatitude());
		}
	}
}
