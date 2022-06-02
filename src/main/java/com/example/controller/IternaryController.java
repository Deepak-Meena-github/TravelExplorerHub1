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

    public String createIternary(int numberOfPassengers){
        return iternaryService.getIternary(numberOfPassengers).getIternaryId();
    }

    public String addPassenger(String passengerId){
        Passenger curPassenger = passengerService.getPassenger(passengerId);
        iternaryService.addPassenger(curPassenger);
        return iternaryService.getIternary().getIternaryId();
    }

    public String addDestination(String destinationId){
        Destination currDestination = destinationService.getDestination(destinationId);
        iternaryService.addDestination(currDestination);
        return iternaryService.getIternary().getIternaryId();
    }

    public void printIternary(){
        Iternary iternary = iternaryService.getIternary();
        System.out.println("Iternary ID : "+iternary.getIternaryId()+"\n"+
        "Iternary Name : "+iternary.getIternaryName()+"\n"+
        "Passenger capacity : "+iternary.getPassengerCapacity());
        System.out.println("List Of destinations");
        for(Destination dest:iternary.getDestinations()){
            System.out.println(dest.getDestinationName());
        }
    }

}
