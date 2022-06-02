package com.example.model;

import java.util.List;
import java.util.Map;

public class PremiumPassenger extends Passenger {

    public PremiumPassenger(String passengerId, String passengerName, int passenegerNumber,
            Map<Destination, List<Activity>> destinationActivitiesMapping) {
        super(passengerId, passengerName, passenegerNumber, destinationActivitiesMapping);
    }

    @Override
    public boolean signUp(Activity activity) {
        return true;
    }
    
}
