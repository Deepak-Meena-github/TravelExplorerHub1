package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.exception.IternaryNotFoundException;
import com.example.model.Destination;
import com.example.model.Iternary;
import com.example.model.Passenger;

public class IternaryService {
    
    private final Map<String,Iternary> iternaryMap;

    public IternaryService(){
        this.iternaryMap = new HashMap<>();
    }

    public Iternary createIternary(String iternaryName, int passengerCapacity){
       Iternary iternary = new Iternary(UUID.randomUUID().toString(), iternaryName, passengerCapacity, new ArrayList<Destination>(), new ArrayList<Passenger>());
       iternaryMap.put(iternary.getIternaryId(), iternary);
       return iternary;
    }

    public Iternary getIternary(String iternaryId){
        if(!this.iternaryMap.containsKey(iternaryId)){
            throw new IternaryNotFoundException();
        }
        return this.iternaryMap.get(iternaryId);
    }

    public void addDestination(Destination destination, String iternaryId){
        if(!this.iternaryMap.containsKey(iternaryId)){
            throw new IternaryNotFoundException();
        }
        this.iternaryMap.get(iternaryId).addDestination(destination);
    }
    
    public void addPassenger(Passenger passenger,String iternaryId)
    {
        if(!this.iternaryMap.containsKey(iternaryId)){
            throw new IternaryNotFoundException();
        }
        this.iternaryMap.get(iternaryId).addPassenger(passenger);
    }
}
