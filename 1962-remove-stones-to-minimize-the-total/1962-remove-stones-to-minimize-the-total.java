class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int pile: piles) {
            sum += pile;
            pq.add(pile);
        }
        for (int i=0; i<k; i++) {
            int d = pq.poll();
            sum -= d/2;
            pq.add(d-(d/2));
        }
        return sum;
        
    }
}