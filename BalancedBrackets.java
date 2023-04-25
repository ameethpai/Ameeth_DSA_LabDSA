import java.util.Stack;


public class BalancedBrackets {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String str1 = "( [ [ { } ] ] )";
        String str2 = "( [ [ { } ] ] ) )";
        if (isBalanced(str1)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
        if (isBalanced(str2)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}