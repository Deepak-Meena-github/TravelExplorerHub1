package com.example.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Passenger {
    protected final String passengerId;
    protected final String passengerName;
    protected final int passenegerNumber;
    protected final Map<Destination,List<Activity>> destinationActivitiesMapping;

    public abstract boolean signUp(Activity activity);
}
