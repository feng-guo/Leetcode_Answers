class Solution {
    Set<Integer> visited;
    List<List<Integer>> rooms;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();
        this.rooms = rooms;
        visited.add(0);
        visit(0);
        
        return visited.size() == rooms.size();
    }
    
    public void visit(int number) {
        for (Integer room: rooms.get(number)) {
            if (visited.add(room)) {
                visit(room);
            }
        }
    }
}