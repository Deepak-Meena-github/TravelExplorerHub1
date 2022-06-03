package com.example.controller;

import com.example.services.IternaryService;
import com.example.services.TravelPackageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TravelPackageController {
    TravelPackageService travelPackageService;
    IternaryService iternaryService;

    public String createTravelPackage(){
        return travelPackageService.createTravelPackage().getTravelPackageId();
    }

    public void addIternary(String iternaryId){
        travelPackageService.addIternary(iternaryService.getIternary(iternaryId));
    }
}
