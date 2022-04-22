package folder22Mar22;

import java.util.Stack;

public class ValidParenthesis {
        public static void main(String args[]) {
        
       System.out.println(isBracesBalanced("{([])}"));
       System.out.println(isBracesBalanced("{}[]()"));
       System.out.println(isBracesBalanced("{}(]"));
       System.out.println(isBracesBalanced("{}{"));

        //output:
        //true
        //true
        //false
        //false
    }
    
    private static boolean isBracesBalanced(String braces) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : braces.toCharArray()) {
            if(isOpeningBracket(c)) {
                stack.push(c);
            } else {
                char lastBracket = stack.peek();
                if(getReverse(c) == lastBracket){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private static boolean isOpeningBracket(char bracket) {
        return bracket == '{' || bracket == '[' || bracket == '(';
    }
    
    private static char getReverse(char bracket) {
        switch(bracket) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return '0';
    }
}
