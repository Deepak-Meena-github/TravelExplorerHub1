package com.example.controller;

import com.example.model.Activity;
import com.example.model.Destination;
import com.example.services.ActivityService;
import com.example.services.DestinationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final DestinationService destinationService;

    public String createActivity(String activityName,String activityDescription,int activityCost,int activityCapacity,String destinationAvailableAtId,int numberOfEnrolled){
        Destination destinationAvailableAt = destinationService.getDestination(destinationAvailableAtId);
        return activityService.createActivity(activityName, activityDescription, activityCost, activityCapacity, destinationAvailableAt, numberOfEnrolled).getActivityId();
    }

    public void printAllActivities(){
        for(Activity currentActivity :activityService.getAllActivities()){
            System.out.println("Activity ID : "+currentActivity.getActivityId()+"\n"+
            "Activity Name : "+currentActivity.getActivityName()+"\n"+
            "Activity Description : "+currentActivity.getActivityDescription()+"\n"+
            "Additional details can be added here");
        }
    }
}
