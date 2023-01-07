class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i=0; i<heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int pop = stack.pop();
                res = Math.max(res, (i-stack.peek()-1)*heights[pop]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int pop = stack.pop();
            res = Math.max(res, (heights.length-stack.peek()-1)*heights[pop]);
        }
        return res;
    }
}