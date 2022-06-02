package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Activity {
    private final String activityId;
    private final String activityName;
    private final String activityDescription;
    private final int activityCost;
    private final int activityCapacity;
    private final Destination destinationAvailableAt;
    private int numberOfEnrolled;

    public void  incrementNumberOfEnrolled()
    {
        this.numberOfEnrolled+=1;
    }
}
