
import java.util.*;

public class Problem_8_Queue_Initial {

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        // enqueue = add in Dequeue Operation = insert at end
        queue.add(2);
        queue.add(4);
        queue.add(5);
        // Dequeue = removeFirst in Dequeue Operation = remove from front or head
        queue.removeFirst();
        System.out.println(queue);


    }


}
