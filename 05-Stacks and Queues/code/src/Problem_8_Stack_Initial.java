import java.util.Deque;
import java.util.LinkedList;

public class Problem_8_Stack_Initial {

    // Sample of Stack
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(2); // addFirst = Push
        stack.addFirst(3);
        System.out.println(stack);
        int x= stack.removeFirst(); // removeFirst = Pop
        System.out.println(x);
        System.out.println(stack.poll());

    }
}
