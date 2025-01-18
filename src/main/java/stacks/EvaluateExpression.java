package stacks;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String expression ="18-(7+(2-4))";
        System.out.println("Expression : " + expression);
        System.out.println("Result : " + (new EvaluateExpression()).evaluateExpression(expression));
    }

    private int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        int sign = 1;
        int result = 0;

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (Character.getNumericValue(c));
            } else if (c == '+' || c == '-') {
                result += (currNum * sign);
                if (c == '-') {
                    sign = -1;
                }
                currNum = 0;
            } else if (c == '(') {
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += currNum * sign;
                result *= stack.pop();
                result += stack.pop();
                currNum = 0;
            }
        }

        return result + currNum * sign;
    }
}
