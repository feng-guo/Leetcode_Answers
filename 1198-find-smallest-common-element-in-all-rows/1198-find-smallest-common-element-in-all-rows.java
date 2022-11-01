class Solution {
    public int smallestCommonElement(int[][] mat) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i=0; i<mat.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<mat[0].length; j++) {
                set.add(mat[i][j]);
            }
            list.add(set);
        }
        
        for (Integer check: list.get(0)) {
            boolean contains = true;
            for (int i=1; i<list.size(); i++) {
                if (!list.get(i).contains(check)) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return check;
            }
        }
        
        return -1;
    }
}