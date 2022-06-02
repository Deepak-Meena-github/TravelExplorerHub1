package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Iternary {
    private final String iternaryId;
    private final String iternaryName;
    private final int passengerCapacity;
    private final List<Destination> destinations;
    private final List<Passenger> passengers;

    public void addDestination(Destination destination)
    {
        this.destinations.add(destination);
    }
    public void addPassenger(Passenger passenger)
    {
        this.passengers.add(passenger);
    }

}
