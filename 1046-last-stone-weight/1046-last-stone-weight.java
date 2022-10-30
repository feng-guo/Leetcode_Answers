class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.add(y-x);
            }
        }
        if (pq.size() == 0) {
            return 0;
        }
        return pq.poll();
    }
}