package com.example;

import com.example.controller.ActivityController;
import com.example.controller.DestinationController;
import com.example.controller.IternaryController;
import com.example.controller.PassengerController;
import com.example.model.PassengerType;
import com.example.services.ActivityService;
import com.example.services.DestinationService;
import com.example.services.IternaryService;
import com.example.services.PassengerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IternaryService iternaryService = new IternaryService();
        PassengerService passengerService = new PassengerService();
        DestinationService destinationService = new DestinationService();
        ActivityService activityService = new ActivityService();
        IternaryController iternaryController = new IternaryController(iternaryService, destinationService, passengerService);
        ActivityController activityController = new ActivityController(activityService, destinationService);
        DestinationController destinationController = new DestinationController(destinationService, activityService);
        PassengerController passengerController = new PassengerController(passengerService, activityService);

        iternaryController.createIternary(5);
        String dest1 = destinationController.createDestination("Rishikesh");
        String dest2 = destinationController.createDestination("Ladakh");
        String activity1 = activityController.createActivity("hiking", "hike", 2000, 3, dest1, 0);
        String activity2 = activityController.createActivity("camping", "camp", 4000, 2, dest2, 0);
        iternaryController.addDestination(dest1);
        iternaryController.addDestination(dest2);
        String pass1 = passengerController.createPassenger(PassengerType.STANDARD, "SK", 1, 100000);
        String pass2 = passengerController.createPassenger(PassengerType.PREMIUM, "RK", 2, 0);
        iternaryController.addPassenger(pass1);
        iternaryController.addPassenger(pass2);
        passengerController.addActivityToPassenger(pass1, activity1);
        passengerController.addActivityToPassenger(pass2, activity2);

        passengerController.printAllActivityAndDestOfPassenger(pass1);
        passengerController.printAllActivityAndDestOfPassenger(pass2);

        iternaryController.printIternary();


    }
}
