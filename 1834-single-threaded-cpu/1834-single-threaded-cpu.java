class Solution {
    public int[] getOrder(int[][] tasks) {
        Map<Integer, Set<Task>> map = new HashMap<>();
        Set<Integer> times = new HashSet<>();
        for (int i=0; i<tasks.length; i++) {
            int[] task = tasks[i];
            Task t = new Task(task[1], i);
            if (map.containsKey(task[0])) {
                map.get(task[0]).add(t);
            } else {
                Set<Task> set = new HashSet<>();
                set.add(t);
                map.put(task[0], set);
            }
            times.add(task[0]);
        }
        List<Integer> sorted = new ArrayList<>(times);
        Collections.sort(sorted);
        int completed = 0;
        int[] order = new int[tasks.length];
        int time = 0;
        Queue<Task> pq = new PriorityQueue<>();
        int index = 0;
        while (completed < tasks.length) {
            while (index < sorted.size() && sorted.get(index) <= time) {
                for (Task t: map.get(sorted.get(index))) {
                    pq.add(t);
                }
                index++;
            }
            if (pq.isEmpty()) {
                time = sorted.get(index);
            } else {
                Task t = pq.poll();
                order[completed] = t.index;
                completed++;
                time += t.time;
            }
            
        }
        return order;
    }
    
    private class Task implements Comparable<Task> {
        int time;
        int index;
        
        public Task(int time, int index) {
            this.time = time;
            this.index = index;
        }
        
        public int compareTo(Task task) {
            if (this.time < task.time) {
                return -1;
            } else if (this.time > task.time) {
                return 1;
            } else if (this.index < task.index) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}