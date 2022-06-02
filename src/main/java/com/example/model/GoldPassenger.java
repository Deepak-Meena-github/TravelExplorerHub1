package com.example.model;

import java.util.List;
import java.util.Map;

import com.example.exception.BalanceInsufficientException;

import lombok.Getter;

@Getter
public class GoldPassenger extends Passenger{
    private int balance;

    public GoldPassenger(String passengerId, String passengerName, int passenegerNumber,
            Map<Destination, List<Activity>> destinationActivitiesMapping, int balance) {
        super(passengerId, passengerName, passenegerNumber, destinationActivitiesMapping);
        this.balance = balance;
    }

    @Override
    public boolean signUp(Activity activity) {
        double effectiveBalance = activity.getActivityCost() *0.9;
        if(balance<effectiveBalance){
            throw new BalanceInsufficientException();
        }
        balance -=effectiveBalance;
        return true;
    }

    

}
