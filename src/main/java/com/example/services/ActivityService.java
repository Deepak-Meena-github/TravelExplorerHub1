package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.exception.ActivityNotFoundException;
import com.example.model.Activity;
import com.example.model.Destination;


public class ActivityService {
    private final Map<String,Activity> activityMap;

    public ActivityService(){
        this.activityMap = new HashMap<>();
    }

    public Activity createActivity(String activityName,String activityDescription,int activityCost,int activityCapacity,Destination destinationAvailableAt,int numberOfEnrolled){
        Activity newActivity= new Activity(UUID.randomUUID().toString(), activityName, activityDescription, activityCost, activityCapacity, destinationAvailableAt,numberOfEnrolled);
        activityMap.put(newActivity.getActivityId(), newActivity);
        return newActivity;
    }

    public Activity getActivityFromId(String activityId){
        if(!this.activityMap.containsKey(activityId)){
            throw new ActivityNotFoundException();
        }
        return this.activityMap.get(activityId);
    }

    public List<Activity> getAllActivities(){
        List<Activity> activities = new ArrayList<>();
        for(Activity current :this.activityMap.values()){
            activities.add(current);
        }
        return activities;
    }

}
