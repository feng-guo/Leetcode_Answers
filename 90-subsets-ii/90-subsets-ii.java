class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> duplicates = new HashMap<>();
        List<Integer> unique = new ArrayList<>();
        for (int num: nums) {
            if (duplicates.containsKey(num)) {
                duplicates.put(num, duplicates.get(num)+1);
            } else {
                duplicates.put(num, 1);
                unique.add(num);
            }
        }
        int max = (int) Math.pow(2, duplicates.keySet().size());
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());
        for (int index=1; index<max; index++) {
            List<List<Integer>> currentListList = new ArrayList<>();
            currentListList.add(new ArrayList());
            int currentSubset = index;
            int currentIndex = 0;
            
            while (currentSubset > 0) {
                if (currentSubset%2 == 1 && duplicates.get(unique.get(currentIndex)) == 1) {
                    for (int i=0; i<currentListList.size(); i++) {
                        currentListList.get(i).add(unique.get(currentIndex));
                    }
                } else if (currentSubset%2 == 1) {
                    List<List<Integer>> copyListList = new ArrayList(currentListList);
                    List<List<Integer>> newListList = new ArrayList<>();
                    for (int i=0; i<currentListList.size(); i++) {
                        List<Integer> copyList = new ArrayList(copyListList.get(i));
                        for (int j=1; j<=duplicates.get(unique.get(currentIndex)); j++) {
                            List<Integer> newList = new ArrayList(copyList);
                            for (int k=0; k<j; k++) {
                                newList.add(unique.get(currentIndex));
                            }
                            newListList.add(newList);
                        }
                    }
                    currentListList = newListList;
                }
                currentSubset >>= 1;
                currentIndex++;
            }
            
            res.addAll(currentListList);
        }
        return res;
    }
}