package com.example.controller;

import com.example.services.ActivityService;
import com.example.services.DestinationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;
    private final ActivityService activityService;

    public String createDestination(String destinationName){
        return destinationService.createDestination(destinationName).getDestinationId();
    }

    public void addActivityToDestination(String destinationId, String activityId){
        destinationService.addActivityToDestination(destinationId, activityService.getActivityFromId(activityId));
    }
    
}
