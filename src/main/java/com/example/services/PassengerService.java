package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.exception.ActivityCapacityFullException;
import com.example.exception.PassengerNotFoundException;
import com.example.model.Activity;
import com.example.model.Destination;
import com.example.model.GoldPassenger;
import com.example.model.Passenger;
import com.example.model.PassengerType;
import com.example.model.PremiumPassenger;
import com.example.model.StandardPassenger;

public class PassengerService {
    private final Map<String,Passenger> passengerMap;

    public PassengerService() {
        this.passengerMap = new HashMap<>();
    }

    public Passenger createPassenger(PassengerType passengerType,String passengerName,int passenegerNumber,int balance){
       Passenger newPassenger = null;
       if(passengerType == PassengerType.STANDARD){
            newPassenger = new StandardPassenger(UUID.randomUUID().toString(), passengerName, passenegerNumber, new HashMap<Destination,List<Activity>>(), balance);
       }
       else if(passengerType == PassengerType.GOLD){
            newPassenger = new GoldPassenger(UUID.randomUUID().toString(), passengerName, passenegerNumber, new HashMap<Destination,List<Activity>>(), balance);
       }
       else if(passengerType == PassengerType.PREMIUM){
            newPassenger = new PremiumPassenger(UUID.randomUUID().toString(), passengerName, passenegerNumber, new HashMap<Destination,List<Activity>>());
       }
       this.passengerMap.put(newPassenger.getPassengerId(), newPassenger);
       return newPassenger;
    }

    public Passenger getPassenger(String passengerId){
        if(!passengerMap.containsKey(passengerId)){
            throw new PassengerNotFoundException();
        }
        return passengerMap.get(passengerId);
    }

    public void addActivityToPassenger(Passenger passenger,Activity activity){
        activity.incrementNumberOfEnrolled();
        if(activity.getActivityCapacity()<activity.getNumberOfEnrolled()){
            throw new ActivityCapacityFullException();
        }
        passenger.signUp(activity);
        Destination activityDestination = activity.getDestinationAvailableAt();
        Map<Destination,List<Activity>> currentDestinationActivityMap = passenger.getDestinationActivitiesMapping();
        List<Activity> newActivities = currentDestinationActivityMap.getOrDefault(activityDestination, new ArrayList<Activity>());
        newActivities.add(activity);
        currentDestinationActivityMap.put(activityDestination, newActivities);
    }

    public List<Passenger> getAllPassengers(){
        List<Passenger> passengers = new ArrayList<>();
        for(Passenger currPassenger : this.passengerMap.values()){
            passengers.add(currPassenger);
        }
        return passengers;
    }
    
}
