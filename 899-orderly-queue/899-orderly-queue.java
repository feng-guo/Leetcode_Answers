class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String best = s;
            String current = s;
            for (int i=0; i<s.length(); i++) {
                current = current.substring(1) + current.charAt(0);
                if (current.compareTo(best) < 0) {
                    best = current;
                }
            }
            
            return best;
        } else {
            Queue<Character> pq = new PriorityQueue<>();
            for (char c: s.toCharArray()) {
                pq.add(c);
            }
            String best = "";
            while (!pq.isEmpty()) {
                best += pq.poll();
            }
            return best;
        }
    }
}