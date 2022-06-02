package com.example.services;

import java.util.ArrayList;
import java.util.UUID;

import com.example.exception.IternaryNotFoundException;
import com.example.model.Destination;
import com.example.model.Iternary;
import com.example.model.Passenger;

public class IternaryService {
    
    private  Iternary iternary;

    public Iternary getIternary(int numberOfPassengers){
        if(iternary == null){
            iternary = new Iternary(UUID.randomUUID().toString(), "MyIternary", numberOfPassengers, new ArrayList<Destination>(), new ArrayList<Passenger>());
            return iternary;
        }
        if(iternary.getPassengerCapacity()!=numberOfPassengers){
            throw new IternaryNotFoundException();
        }
        return iternary;
    }

    public Iternary getIternary(){
        if(iternary == null){
            throw new IternaryNotFoundException();
        }
        return iternary;
    }
    public void addDestination(Destination destination){
        iternary.addDestination(destination);
    }
    
    public void addPassenger(Passenger passenger)
    {
        iternary.addPassenger(passenger);
    }
}
