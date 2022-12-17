class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token: tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(two - one);
            } else if (token.equals("/")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(two / one);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return (int) stack.pop();
        
    }
}