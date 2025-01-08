package oel;

import java.util.ArrayList;
import java.util.List;

class SmartCitySimulation {
    Graph cityGraph;
    List<Vehicle> vehicles;
    CongestionManager congestionManager;
    TrafficLightController trafficLightController;
    Pathfinding pathfinder;

    public SmartCitySimulation(Graph cityGraph) {
        this.cityGraph = cityGraph;
        this.vehicles = new ArrayList<>();
        this.congestionManager = new CongestionManager();
        this.trafficLightController = new TrafficLightController();
        this.pathfinder = new Pathfinding();
    }

    public void runSimulation() {
        // Initialize traffic lights for all intersections
        trafficLightController.initializeTrafficLights(cityGraph);

        for (Vehicle vehicle : vehicles) {
            // Calculate the optimal route for the vehicle
            List<Integer> route = pathfinder.calculateRoute(cityGraph, vehicle.currentLocation, vehicle.destination);
            vehicle.route = route;

            // Move the vehicle along its route (simulate the movement)
            for (Integer intersection : vehicle.route) {
                System.out.println("Vehicle " + vehicle.id + " moving through intersection " + intersection);
                congestionManager.updateCongestion(cityGraph.adjList.get(vehicle.currentLocation).get(0)); // Simplified for one road
                trafficLightController.adjustTrafficLights(intersection, vehicle.route.size());
            }
        }
    }
}
