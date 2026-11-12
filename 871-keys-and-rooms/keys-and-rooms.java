class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs(0, rooms, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int currRoom, List<List<Integer>> rooms, boolean[] visited) {
        visited[currRoom] = true;
        
        for (int nextRoom : rooms.get(currRoom)) {
            if (!visited[nextRoom]) {
                dfs(nextRoom, rooms, visited);
            }
        }
    }
}