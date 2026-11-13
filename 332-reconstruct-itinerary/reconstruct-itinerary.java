class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", graph, route);
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, route);
        }
        
        route.addFirst(airport);
    }
}