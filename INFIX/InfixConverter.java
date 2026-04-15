import java.util.*;
public class InfixConverter {
    // function to check precedence
    static int precedence(char ch) {
        switch (ch){
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    // convert infix to postfix
    static String infixtopostfix (String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);

            // if operand add to result
            if (Character.isLetterOrDigit(c)){
                result.append(c);
            }
            // if '(', push to stack
            else if (c == '('){
                stack.push(c);
            }
            // if ')', pop from stack until '('
            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()){
                    stack.pop(); // remove '('
                }
            }
            // if operator
            else{
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
    //convert infix to prefix
    static String infixtoprefix (String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--){
            char c = exp.charAt(i);

            // if operand add to result
            if (Character.isLetterOrDigit(c)){
                result.append(c);
            }
            // if ')', push to stack
            else if (c == ')'){
                stack.push(c);
            }
            // if '(', pop from stack until ')'
            else if (c == '('){
                while (!stack.isEmpty() && stack.peek() != ')'){
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()){
                    stack.pop(); // remove ')'
                }
            }
            // if operator
            else{
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infix = sc.nextLine();
        System.out.print("Convert to (postfix/prefix): ");
        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("postfix")){
            String postfix = infixtopostfix(infix);
            System.out.println("Postfix expression: " + postfix);
        } else if (choice.equals("prefix")){
            String prefix = infixtoprefix(infix);
            System.out.println("Prefix expression: " + prefix);
        } else {
            System.out.println("Invalid choice. Please choose 'postfix' or 'prefix'.");
        }
    }
}
