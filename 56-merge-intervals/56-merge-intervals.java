class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval: intervals) {
            list.add(interval);
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        int[] current = list.get(0);
        List<int[]> merged = new ArrayList<>();
        for (int i=1; i<list.size(); i++) {
            if (list.get(i)[0] <= current[1]) {
                current[1] = Math.max(list.get(i)[1], current[1]);
            } else {
                merged.add(current);
                current = list.get(i);
            }
        }
        merged.add(current);
        
        int[][] res = new int[merged.size()][2];
        for (int i=0; i<merged.size(); i++) {
            res[i] = merged.get(i);
        }
        return res;
    }
}