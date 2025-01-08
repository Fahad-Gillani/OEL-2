package oel;

import java.util.*;

class Road {
    int destination;
    int distance;
    int trafficLoad; // Number of vehicles currently on this road
    
    public Road(int destination, int distance, int trafficLoad) {
        this.destination = destination;
        this.distance = distance;
        this.trafficLoad = trafficLoad;
    }
}

class Graph {
    Map<Integer, List<Road>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add road between two intersections
    public void addEdge(int src, int dest, int distance, int trafficLoad) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(new Road(dest, distance, trafficLoad));
    }
}
