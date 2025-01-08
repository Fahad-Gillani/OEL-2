package oel;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    String id;
    int currentLocation;
    int destination;
    List<Integer> route; // Stores the preferred route

    public Vehicle(String id, int currentLocation, int destination) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.route = new ArrayList<>();
    }
}
