class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(i*n+j);
                }
            }
        }
        
        while (q.size() > 0) {
            int current = q.poll();
            int x = current/n;
            int y = current%n;
            int value = rooms[x][y]+1;
            if (x!=0 && rooms[x-1][y] > value) {
                rooms[x-1][y] = value;
                q.add((x-1)*n+y);
            }
            if (x!=m-1 && rooms[x+1][y] > value) {
                rooms[x+1][y] = value;
                q.add((x+1)*n+y);
            }
            if (y!=0 && rooms[x][y-1] > value) {
                rooms[x][y-1] = value;
                q.add(x*n+(y-1));
            }
            if (y!=n-1 && rooms[x][y+1] > value) {
                rooms[x][y+1] = value;
                q.add(x*n+(y+1));
            }
        }
    }
}