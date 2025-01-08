package oel;

public class Main {
    public static void main(String[] args) {
        // Create a city graph with intersections and roads
        Graph cityGraph = new Graph();
        cityGraph.addEdge(0, 1, 10, 5);
        cityGraph.addEdge(1, 2, 5, 2);
        cityGraph.addEdge(2, 3, 8, 3);
        
        // Create a traffic light controller
        TrafficLightController trafficLightController = new TrafficLightController();
        
        // Create vehicles
        Vehicle vehicle1 = new Vehicle("V1", 0, 3);
        Vehicle vehicle2 = new Vehicle("V2", 1, 3);
        
        // Create the simulation
        SmartCitySimulation simulation = new SmartCitySimulation(cityGraph);
        simulation.vehicles.add(vehicle1);
        simulation.vehicles.add(vehicle2);

        // Run the simulation
        simulation.runSimulation();
    }
}
