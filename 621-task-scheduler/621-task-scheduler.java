class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        // Map<Character, Integer> last = new HashMap<>();
        // List<Pair<Character, Integer>> on_cooldown
        
        Comparator<Pair<Character, Integer>> comp = new Comparator<>() {
            @Override
            public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                return -Integer.compare(p1.getValue(), p2.getValue());
            }
        };
        
        Comparator<Pair<Character, Integer>> comp2 = new Comparator<>() {
            @Override
            public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                return Integer.compare(p1.getValue(), p2.getValue());
            }
        };
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(comp);
        PriorityQueue<Pair<Character, Integer>> cd = new PriorityQueue<>(comp2);
        
        for (char task: tasks) {
            if (map.containsKey(task)) {
                map.put(task, map.get(task) + 1);
            } else {
                map.put(task, 1);
            }
        }
        
        for (Character key: map.keySet()) {
            Pair<Character, Integer> pair = new Pair<>(key, map.get(key));
            pq.add(pair);
        }
        
        int time = 0;
        
        while(!pq.isEmpty() || !cd.isEmpty()) {
            boolean stop = false;
            while (!stop) {
                if (cd.isEmpty()) {
                    stop = true;
                } else {
                    Pair<Character, Integer> p = cd.peek();
                    if (time - p.getValue() > n) {
                        Pair<Character, Integer> insert = new Pair<>(cd.peek().getKey(), map.get(cd.peek().getKey()));
                        pq.add(insert);
                        cd.poll();
                    } else {
                        stop = true;
                    }
                }
            }
            if (!pq.isEmpty()) {
                Pair<Character, Integer> task = pq.poll();
                if (map.get(task.getKey()) == 1) {
                    map.remove(task.getKey());
                } else {
                    map.put(task.getKey(), map.get(task.getKey()) - 1);
                    Pair<Character, Integer> cooldown = new Pair<>(task.getKey(), time);
                    cd.add(cooldown);
                }
            }
            
            time++;
        }
        
        return time;
        
    }
}