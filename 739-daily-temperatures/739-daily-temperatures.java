class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int[] days = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            int t = temperatures[i];
            while (!temp.isEmpty() && t > temp.peek()) {
                temp.pop();
                int popped = index.pop();
                days[popped]= i - popped; 
            }
            temp.push(t);
            index.push(i);
        } 
        
        return days;
    }
}