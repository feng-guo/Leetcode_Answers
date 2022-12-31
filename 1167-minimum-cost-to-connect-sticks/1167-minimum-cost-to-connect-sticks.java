class Solution {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int stick: sticks) {
            pq.add(stick);
        }
        while (pq.size() > 1) {
            int t = pq.poll() + pq.poll();
            cost += t;
            pq.add(t);
        }
        return cost;
    }
}