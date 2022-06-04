import java.util.Deque;
import java.util.LinkedList;

public class Problem_8_3 {
    // TEST A string over the characters "{,},(,),[,]" is said to be well-formed if the different types
    //of brackets match in the correct order

    public static void main(String[] args) {
        String s = "[,],{,}";
        System.out.println(checkValidityOfString(s));
    }


    // Time 0(n)
    public static boolean checkValidityOfString(String s)
    {
        Deque<String> stack = new LinkedList<>();
        String[] stringArray = s.split(",");
        for (String bracket : stringArray)
        {
            // if its left bracket then add it to stack
            if("[{(".contains(bracket))
            {
                stack.addFirst(bracket);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }

                String shouldMatchBracket = stack.removeFirst();
                if(
                        (bracket.equals("}") && shouldMatchBracket.equals("{")) ||
                        (bracket.equals("]") && shouldMatchBracket.equals("[")) ||
                        (bracket.equals(")") && shouldMatchBracket.equals("("))
                )
                {

                }
                else
                {
                    return false;
                }
            }
        }

        // after this stack should be empty
        return stack.isEmpty();
    }

}
