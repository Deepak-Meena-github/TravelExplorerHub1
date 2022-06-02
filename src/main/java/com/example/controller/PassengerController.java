package com.example.controller;

import java.util.List;
import java.util.Map;

import com.example.model.Activity;
import com.example.model.Destination;
import com.example.model.Passenger;
import com.example.model.PassengerType;
import com.example.services.ActivityService;
import com.example.services.PassengerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;
    private final ActivityService activityService;

    public String createPassenger(PassengerType passengerType, String passengerName, int passenegerNumber, int balance){
        return passengerService.createPassenger(passengerType, passengerName, passenegerNumber, balance).getPassengerId();
    }

    public void addActivityToPassenger(String passengerId, String activityId){
        passengerService.addActivityToPassenger(passengerService.getPassenger(passengerId), activityService.getActivityFromId(activityId));
    }

    public void printAllActivityAndDestOfPassenger(String passengerId){
       Passenger currPassenger = passengerService.getPassenger(passengerId);
       for(Map.Entry<Destination,List<Activity>> currMapping : currPassenger.getDestinationActivitiesMapping().entrySet()){
           System.out.println("Passenger : "+currPassenger.getPassengerName()+"\n"+
           "Destination : "+currMapping.getKey().getDestinationName());
           System.out.println("List of Activities");
           for(Activity currActivity : currMapping.getValue()){
               System.out.println(currActivity.getActivityName());
           }
       }
       System.out.println("");
    }

}
