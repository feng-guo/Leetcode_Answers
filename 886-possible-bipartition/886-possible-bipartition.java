class Solution {
    Set<Integer> g1;
    Set<Integer> g2;
    Set<Integer> placed;
    Map<Integer, Set<Integer>> map;
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        g1 = new HashSet<>();
        g2 = new HashSet<>();
        placed = new HashSet<>();
        map = new HashMap<>();
        if (dislikes.length > 0) {
            for (int[] c: dislikes) {
                int n1 = c[0];
                int n2 = c[1];
                if (map.containsKey(n1)) {
                    map.get(n1).add(n2);
                } else {
                    Set<Integer> t = new HashSet<>();
                    t.add(n2);
                    map.put(n1, t);
                }
                if (map.containsKey(n2)) {
                    map.get(n2).add(n1);
                } else {
                    Set<Integer> t = new HashSet<>();
                    t.add(n1);
                    map.put(n2, t);
                }
            }
        }
        
        
        
        
        
        int counter = 1;
        Queue<Integer> pq = new ArrayDeque<>();
        pq.add(1);
        g1.add(1);
        placed.add(1);
        while (counter <= n) {
            if (pq.isEmpty()) {
                if (placed.contains(counter)) {
                    counter++;
                } else {
                    pq.add(counter);
                    placed.add(counter);
                    g1.add(counter);
                }
            } else {
                int c = pq.poll();
                Set<Integer> set = g1.contains(c) ? g1 : g2;
                Set<Integer> other = g1.contains(c) ? g2: g1;
                if (map.containsKey(c)) {
                    for (int d: map.get(c)) {
                        if (placed.contains(d) && set.contains(d)) {
                            return false;
                        } else if (!placed.contains(d)) {
                            other.add(d);
                            placed.add(d);
                            pq.add(d);
                        }
                    }  
                }
            }
        }
        return true;
    }
}