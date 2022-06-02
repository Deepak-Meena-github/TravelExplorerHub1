package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Destination {
    private final String destinationId;
    private final String destinationName;
    private final List<Activity> activities;

    public void addActivity(Activity activity){
        this.activities.add(activity);
    }
}
