import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Problem_8_8 {

    // IMPLEMENT A QUEUE USING STACKS

    public static void main(String[] args) {

    }

    // Time 0(n) where n = no of Operation, each element push or pop no more than twice
    public class QueueUsingStack {
        private Deque<Integer> enq = new LinkedList<>();
        private Deque<Integer> deq = new LinkedList<>();

        public void enqueue(int x){
            enq.addFirst(x);
        }

        public Integer dequeue(){

            if(deq.isEmpty())
            {
                // Transfer all elemenets from enq to deq
                while(!enq.isEmpty())
                {
                    deq.addFirst(enq.removeFirst());
                }


            }
            if(!deq.isEmpty())
            {
                return deq.removeFirst();
            }

            throw new NoSuchElementException("Queue is Empty");
        }
    }
}
