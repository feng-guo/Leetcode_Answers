class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        
        return res;
    }
}