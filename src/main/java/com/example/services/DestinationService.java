package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.exception.DestinationNotFoundException;
import com.example.model.Activity;
import com.example.model.Destination;

public class DestinationService {
    private final Map<String,Destination> destinationMap;

    public DestinationService() {
        destinationMap = new HashMap<>();
    }

    public Destination createDestination(String destinationName){
        Destination newDestination = new Destination(UUID.randomUUID().toString(), destinationName, new ArrayList<Activity>());
        this.destinationMap.put(newDestination.getDestinationId(), newDestination);
        return newDestination;
    }

    public Destination getDestination(String destinationId){
        if(!destinationMap.containsKey(destinationId)){
            throw new DestinationNotFoundException();
        }
        return destinationMap.get(destinationId);
    }
    
    public void addActivityToDestination(String destinationId,Activity activity){
        if(!this.destinationMap.containsKey(destinationId)){
            throw new DestinationNotFoundException();
        }
        this.destinationMap.get(destinationId).addActivity(activity);
    }

    public List<Destination> getAllDestinations(){
        List<Destination> destinations = new ArrayList<>();
        for(Destination curDestination : this.destinationMap.values()){
            destinations.add(curDestination);
        } 
        return destinations;
    }
}
