package oel;

import java.util.Comparator;
import java.util.PriorityQueue;

class CongestionManager {
    PriorityQueue<Road> congestionQueue;

    public CongestionManager() {
        congestionQueue = new PriorityQueue<>(Comparator.comparingInt(r -> r.trafficLoad));
    }

    // Add road to the priority queue
    public void updateCongestion(Road road) {
        congestionQueue.offer(road);
    }

    // Get the most congested road
    public Road getMostCongestedRoad() {
        return congestionQueue.poll();
    }
}
