class Solution {
    public int calculate(String s) {
        if (true) {
            Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
        }
        if (false) {
            Stack<String> stack = new Stack<>();
            String current = "";
            
            for(char c: s.toCharArray()) {
                if (c == '+' || c == '-' || c == '(' || c == ' ' || c == ')') {
                    if (!current.equals("")) {
                        if (stack.size() >= 1 && stack.peek().equals("-")) {
                            if (stack.size() > 1) {
                                String temp = stack.pop();
                                if (stack.peek().equals("(")) {
                                    current = "-" + current;
                                }
                            } else {
                                stack.pop();
                                current = "-" + current;
                            } 
                        }
                        stack.push(current);
                        current = "";
                    }
                    if (c == '+' || c == '-' || c == '(') {
                        stack.push(c+"");
                    } else if (c == ')') {
                        String pop1 = stack.pop();
                        if (pop1.equals("(")) {
                            continue;
                        }
                        //At this point, pop1 needs to be a number;
                        String pop2 = stack.pop();
                        if (pop2.equals("(")) {
                            continue;
                        }
                        
                        int pop3;
                        int pop4;
                    }
                    
                } else {
                    current += c;
                }
                
                
                
//                 else if (c != ' ' && c != ')') {
//                     current += c;
//                 } else {
//                     stack.push(current);
//                     current = "";

//                     int res;

//                     if (stack.size() > 3) {

//                     }
//                     if (c == ')') {
//                         stack.pop();
//                     }
//                     stack.push(res+"");
//                 }
            }

            
            //need to resolve the stack
            if (stack.size() > 1) {
                int res = Integer.parseInt(stack.pop()) * -1;
            }
            return Integer.parseInt(stack.pop());
        } else {
            return 0;
        }
    }
}