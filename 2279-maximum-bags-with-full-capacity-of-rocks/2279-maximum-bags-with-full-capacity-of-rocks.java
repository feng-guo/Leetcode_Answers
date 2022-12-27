class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i=0; i<rocks.length; i++) {
            rocks[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(rocks);
        for (int i=0; i<rocks.length; i++) {
            if (rocks[i] > additionalRocks) {
                return i;
            } else {
                additionalRocks -= rocks[i];
            }
        }
        return rocks.length;
    }
}