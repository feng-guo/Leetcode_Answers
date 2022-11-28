class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Set<Integer> lost0 = new TreeSet<>();
        Set<Integer> lost1 = new TreeSet<>();
        Set<Integer> lost = new HashSet<>();
        for (int[] match: matches) {
            if (players.add(match[0])) {
                lost0.add(match[0]);
            }
            players.add(match[1]);
            if (lost1.contains(match[1])) {
                lost1.remove(match[1]);
                lost.add(match[1]);
            } else if (!lost1.contains(match[1]) && !lost.contains(match[1])) {
                if (lost0.contains(match[1])) {
                    lost0.remove(match[1]);
                }
                lost1.add(match[1]);
            }
        }
        List<Integer> lost0_r = new ArrayList<>(lost0);
        List<Integer> lost1_r = new ArrayList<>(lost1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(lost0_r);
        res.add(lost1_r);
        return res;
    }
}