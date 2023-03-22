class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean placed = false;
        for (int[] interval: intervals) {
                if (interval[0] > newInterval[1]) {
                    if (!placed) {
                        list.add(newInterval);
                        placed = true;
                    }
                    list.add(interval);
                } else if (interval[1] >= newInterval[0] && interval[1] <= newInterval[1]) {
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                } else if (interval[0] >= newInterval[0] && interval[0] <= newInterval[1]) {
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                } else if (newInterval[0] >= interval[0] && newInterval[1] <= interval[1]) {
                    list.add(interval);
                    placed = true;
                } else {
                    list.add(interval);
                }
        }
        if (!placed) {
            list.add(newInterval);
        }
        int[][] res = new int[list.size()][2];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}