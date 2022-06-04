import java.util.NoSuchElementException;

public class Problem_8_9 {

    // IMPLEMENT A QUEUE WITH MAX API

    public static void main(String[] args) {
            QueueWithMax q = new QueueWithMax();
            q.enqueue(8);
            q.enqueue(7);
            q.enqueue(6);
            q.dequeue();
            q.enqueue(12);
        System.out.println(q.max());

    }

    // Time 0(1) amortized complexity
    public static class QueueWithMax{
        // we can use two stack-with-max from Problem 8_1
        private Problem_8_1.StackWithMax enqueue = new Problem_8_1.StackWithMax();
        private Problem_8_1.StackWithMax dequeue = new Problem_8_1.StackWithMax();

        public void enqueue(int x)
        {
            enqueue.push(x);
        }

        public int dequeue()
        {
            if(dequeue.isEmpty())
            {
                while(!enqueue.isEmpty())
                {
                    dequeue.push(enqueue.pop());
                }
            }

            if(!dequeue.isEmpty())
            {
                return dequeue.pop();
            }

            throw new NoSuchElementException("Queue is already Empty");
        }

        public int max()
        {
            if(!enqueue.isEmpty())
            {
                if(dequeue.isEmpty())
                {
                    return enqueue.max();
                }

                return Math.max(enqueue.max(),dequeue.max());
            }

            if(!dequeue.isEmpty())
            {
                return dequeue.max();
            }

            throw new NoSuchElementException("Queue is already Empty");

        }

    }
}
