package oel;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pathfinding {
    // Dijkstra's Algorithm to find the shortest path from start to destination
    public List<Integer> calculateRoute(Graph graph, int start, int destination) {
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        dist.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            int node = pq.poll().getKey();
            if (node == destination) break;

            for (Road road : graph.adjList.getOrDefault(node, Collections.emptyList())) {
                int newDist = dist.get(node) + road.distance + road.trafficLoad; // Considering congestion
                if (newDist < dist.getOrDefault(road.destination, Integer.MAX_VALUE)) {
                    dist.put(road.destination, newDist);
                    prev.put(road.destination, node);
                    pq.add(new AbstractMap.SimpleEntry<>(road.destination, newDist));
                }
            }
        }

        // Reconstruct the path from destination to start
        List<Integer> path = new ArrayList<>();
        for (Integer at = destination; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
