import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem_8_2 {
    // EVALUATE RPN EXPRESSIONS

    // For example, the following strings satisfy these rules: "1729", "3,4, +,2, X,1, +",
    //"1,1, +,-2, x", "-641,6, /,28, /"

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your RPN expression : ");
//        String rpnExpression = sc.next();
//        System.out.println(evaluateRPN(rpnExpression));

        System.out.print("Enter your PN expression : ");
        String pnExpression = sc.next();
        System.out.println(evaluatePN(pnExpression));


    }

    // Time 0(n) and space is constant
    public static int evaluatePN(String exp)
    {
        String[] expArray = exp.split(",");

        Deque<Integer> stack = new LinkedList<>();

        // Start from end
        // store numbers in stack and when arithmetic comes then pop last two numbers from stack
        // evaluate and add answer to stack

        for (int i = expArray.length-1; i >=0; i--) {
            String e = expArray[i];
            if (e.length() == 1 && "+-%*/".contains(e)) {
                // it means arithmetic expression
                final int b = stack.removeFirst();
                final int a = stack.removeFirst();
                switch (e.charAt(0)) {
                    case '+':
                        stack.addFirst(a + b);
                        break;
                    case '-':
                        stack.addFirst(a - b);
                        break;
                    case '*':
                        stack.addFirst(a * b);
                        break;
                    case '/':
                        stack.addFirst(a / b);
                        break;
                    default:
                        throw new IllegalArgumentException("It is invalid exp " + e);
                }

            } else {
                stack.addFirst(Integer.parseInt(e));
            }
        }

        return stack.removeFirst();
    }

    // Time 0(n) and space is constant
    public static int evaluateRPN(String exp)
    {
        String[] expArray = exp.split(",");

        Deque<Integer> stack = new LinkedList<>();

        // store numbers in stack and when arithmetic comes then pop last two numbers from stack
        // evaluate and add answer to stack

        for(String e : expArray)
        {
            if(e.length()==1 && "+-%*/".contains(e))
            {
                // it means arithmetic expression
                final int b = stack.removeFirst();
                final int a = stack.removeFirst();
                switch(e.charAt(0))
                {
                    case '+':
                        stack.addFirst(a+b);
                        break;
                    case '-':
                        stack.addFirst(a-b);
                        break;
                    case '*':
                        stack.addFirst(a*b);
                        break;
                    case '/':
                        stack.addFirst(a/b);
                        break;
                    default:
                        throw new IllegalArgumentException("It is invalid exp "+e);
                }

            }
            else
            {
                stack.addFirst(Integer.parseInt(e));
            }
        }

        return stack.removeFirst();
    }
}
