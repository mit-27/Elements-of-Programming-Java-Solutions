import java.util.Deque;
import java.util.LinkedList;

public class Problem_8_1 {

    // IMPLEMENT A STACK WITH MAX API

    // Design a stack that includes a max operation, in addition to push and pop. The max
    //method should return the maximum value stored in the stack.

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(45);
        s.push(0);
        System.out.println(s.max());
    }

    private static class ElementWithMax {
        private Integer element;
        private Integer max;

        public ElementWithMax(Integer element,Integer max)
        {
            this.element = element;
            this.max = max;
        }
    }

    private static class Stack{

        private Deque<ElementWithMax> stack = new LinkedList<>();

        public void push(Integer x)
        {
            if(isEmpty())
            {
                stack.addFirst(new ElementWithMax(x,x));
            }
            else{
                // as we stored max at every node while we adding then it means last inserted have latest max
                if(x > stack.peek().max)
                {
                    stack.addFirst(new ElementWithMax(x,x));
                }
                else
                {
                    stack.addFirst(new ElementWithMax(x,stack.peek().max));
                }
            }
        }

        public Integer pop()
        {
            if(isEmpty())
            {
                System.out.println("Stack is Empty");
                return -1;
            }

            return stack.removeFirst().element;
        }

        public Integer max()
        {
            if(isEmpty())
            {
                System.out.println("Stack is Empty");
                return -1;
            }

            return stack.peek().max;
        }

        public boolean isEmpty()
        {
            return stack.isEmpty();
        }
    }
}
