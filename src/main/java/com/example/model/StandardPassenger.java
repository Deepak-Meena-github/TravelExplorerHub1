package com.example.model;

import java.util.List;
import java.util.Map;

import com.example.exception.BalanceInsufficientException;

import lombok.Getter;

@Getter
public class StandardPassenger extends Passenger {
    private int balance;

    public StandardPassenger(String passengerId, String passengerName, int passenegerNumber,
            Map<Destination, List<Activity>> destinationActivitiesMapping,int balance) {
        super(passengerId, passengerName, passenegerNumber, destinationActivitiesMapping);
        this.balance = balance;
    }

    @Override
    public boolean signUp(Activity activity) {
        if(activity.getActivityCost()>balance){
            throw new BalanceInsufficientException();
        }
        balance-=activity.getActivityCost();
        return true;
    }
    
}
