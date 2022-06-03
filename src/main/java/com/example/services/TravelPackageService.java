package com.example.services;

import java.util.ArrayList;
import java.util.UUID;

import com.example.model.Iternary;
import com.example.model.TravelPackage;



public class TravelPackageService {
    private TravelPackage travelPackage;

    public TravelPackage createTravelPackage()
    {
        if(travelPackage == null)
        {
            this.travelPackage = new TravelPackage(UUID.randomUUID().toString(), new ArrayList<Iternary>());
        }
        return this.travelPackage;
    }
    public TravelPackage getTravelPackage() {
        return this.travelPackage;
    }

    public void addIternary(Iternary iternary){
        this.travelPackage.getIternaries().add(iternary);
    }
}
