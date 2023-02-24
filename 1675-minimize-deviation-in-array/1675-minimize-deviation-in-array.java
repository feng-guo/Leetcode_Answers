class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        // pretreatment
        List<List<Integer>> possibleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> candidates = new ArrayList<>();
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                candidates.add(temp);
                while (temp % 2 == 0) {
                    temp /= 2;
                    candidates.add(temp);
                }
            } else {
                candidates.add(nums[i] * 2);
                candidates.add(nums[i]);
            }
            // reverse candidates to sort from small to large
            Collections.reverse(candidates);
            possibleList.add(candidates);
        }
        List<int[]> pointers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = possibleList.get(i).size();
            for (int j = 0; j < size; j++) {
                pointers.add(new int[] { possibleList.get(i).get(j), i, j });
            }
        }
        pointers.sort(Comparator.comparingInt(p -> p[0]));
        int minDeviation = Integer.MAX_VALUE;
        int currentEnd = 0;
        for (int i = 0; i < n; i++) {
            currentEnd = Math.max(currentEnd, possibleList.get(i).get(0));
        }
        for (int[] current : pointers) {
            int currentStart = current[0];
            int index = current[1];
            int indexInCandidates = current[2];
            if (minDeviation > currentEnd - currentStart) {
                minDeviation = currentEnd - currentStart;
            }
            // if the pointer reach last
            if (indexInCandidates + 1 == possibleList.get(index).size()) {
                return minDeviation;
            }
            int nextValue = possibleList.get(index).get(indexInCandidates + 1);
            currentEnd = Math.max(currentEnd, nextValue);
        }
        return minDeviation;
    }
}