/***
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        int x, y;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i]))
                st.push(calc(st.pop(), st.pop(), tokens[i]));
            else 
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.pop();
    }

    private boolean isOperator(String s) {
        String str = new String("+-*/");
        return s.length() == 1 && str.indexOf(s.charAt(0)) != -1;
    }

    private Integer calc(int num2, int num1, String op) {
        switch (op.charAt(0)) {
            case '+':   return num1 + num2;
            case '-':   return num1 - num2;
            case '*':   return num1 * num2;
            case '/':   return num1 / num2;
            default:   return 0;
        }
    }
}
