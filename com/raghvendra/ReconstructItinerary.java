package com.raghvendra;

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

 */

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Create a List to store the result of Itinerary
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return result;
        //Create a Map, key as String (Airport dest Name) and value as List of the Arrival ports
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        //Make the connections with each ticket and in case if a person can reach two place from one airport than it is handled by PQ
        //sorted in lexical order
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        travel("JFK", result, map);
        return result;
    }

    private void travel(String airport, List<String> result, Map<String,PriorityQueue<String>> map){
        PriorityQueue<String> pq = map.get(airport);
        while(pq != null && !pq.isEmpty()){
            travel(pq.poll(),result,map);
        }
        result.add(0, airport);
    }
}
