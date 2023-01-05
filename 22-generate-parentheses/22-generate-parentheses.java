class Solution {
    Stack<Character> stack;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        stack = new Stack<>();
        res = new ArrayList<>();
        generate("", n*2);
        
        return res;
    }
    
    public void generate(String s, int n) {
        if (n==0) {
            if (stack.isEmpty()) {
                res.add(s);
            }
            return;
        }
        stack.push('(');
        generate(s+"(", n-1);
        stack.pop();
        if (!stack.isEmpty()) {
            stack.pop();
            generate(s+")", n-1);
            stack.push('(');
        }
    }
}