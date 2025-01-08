package oel;

import java.util.HashMap;
import java.util.Map;

class TrafficLightController {
    Map<Integer, TrafficLight> trafficLights;

    public TrafficLightController() {
        this.trafficLights = new HashMap<>();
    }

    // Initialize traffic lights for all intersections
    public void initializeTrafficLights(Graph cityGraph) {
        for (Integer intersection : cityGraph.adjList.keySet()) {
            trafficLights.putIfAbsent(intersection, new TrafficLight());
        }
    }

    // Simulate adjusting traffic lights based on traffic conditions
    public void adjustTrafficLights(int intersectionId, int vehicleCount) {
        TrafficLight light = trafficLights.get(intersectionId);
        
        // Ensure the traffic light is initialized before adjusting
        if (light != null) {
            if (vehicleCount > 10) {
                light.isGreen = true;  // Keep the light green longer for congested roads
            } else {
                light.isGreen = false;
            }
        } else {
            System.out.println("Traffic light not found for intersection " + intersectionId);
        }
    }
}
