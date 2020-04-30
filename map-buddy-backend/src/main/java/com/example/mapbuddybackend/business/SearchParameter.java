package com.example.mapbuddybackend.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchParameter {


    private String location;

    @JsonProperty("businessNames")
    private List<String> businessNames;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getBusinessNames() {
        return businessNames;
    }

    public void setBusinessNames(List<String> businessNames) {
        this.businessNames = businessNames;
    }

    public void addBusinessNames(String newBusiness) {
        businessNames.add(newBusiness);
    }

    public void printAllBusinessNames() {
        for (int i = 0; i < businessNames.size(); i++) {
            System.out.println(businessNames.get(i));
        }
    }





}
