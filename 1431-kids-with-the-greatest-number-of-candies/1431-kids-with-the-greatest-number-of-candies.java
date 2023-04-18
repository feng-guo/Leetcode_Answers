class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy: candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> list = new ArrayList<>();
        for (int i=0; i<candies.length; i++) {
            list.add(candies[i] + extraCandies >= max);
        }
        return list;
    }
}