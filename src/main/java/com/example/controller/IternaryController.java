package com.example.controller;

import com.example.model.Destination;
import com.example.model.Iternary;
import com.example.model.Passenger;
import com.example.services.DestinationService;
import com.example.services.IternaryService;
import com.example.services.PassengerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IternaryController {
    private final IternaryService iternaryService;
    private final DestinationService destinationService;
    private final PassengerService passengerService;

    public String createIternary(String iternaryName,int passengerCapacity){
        return iternaryService.createIternary(iternaryName, passengerCapacity).getIternaryId();
    }

    public void addPassenger(String passengerId,String iternaryId){
        Passenger curPassenger = passengerService.getPassenger(passengerId);
        iternaryService.addPassenger(curPassenger, iternaryId);
    }

    public void addDestination(String destinationId,String iternaryId){
        Destination currDestination = destinationService.getDestination(destinationId);
        iternaryService.addDestination(currDestination,iternaryId);
    }

    public void printIternary(String iternaryId){
        Iternary iternary = iternaryService.getIternary(iternaryId);
        System.out.println("Iternary ID : "+iternary.getIternaryId()+"\n"+
        "Iternary Name : "+iternary.getIternaryName()+"\n"+
        "Passenger capacity : "+iternary.getPassengerCapacity());
        System.out.println("List Of destinations");
        for(Destination dest:iternary.getDestinations()){
            System.out.println(dest.getDestinationName());
        }
    }

}
