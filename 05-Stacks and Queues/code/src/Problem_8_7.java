import java.util.Arrays;

public class Problem_8_7 {

    // IMPLEMENT A CIRCULAR QUEUE

    // Implement a queue API using an array for storing elements. Your API should include
    //a constructor function, which takes as argument the initial capacity of the queue,
    //enqueue and dequeuefunctions,and a function which returns the number of elements
    //stored. Implement dynamic resizing to support storing an arbitrarily large number
    //of elements.

    public static void main(String[] args) {

        CircularQueue circularQueue = new CircularQueue(2);
        circularQueue.enqueue(2);
        circularQueue.enqueue(5);
        circularQueue.enqueue(7);
        circularQueue.dequeue();
        System.out.println(circularQueue);

    }

    public static class CircularQueue {
        private int capacity = 2;
        private int size=0;
        private int head = 0;
        private int tail=0;
        private int[] entries;
        final int SCALE_FACTOR = 2;

        public CircularQueue(int capacity)
        {
            this.capacity = capacity;
            this.entries = new int[capacity];
        }

        public void enqueue(int element)
        {
            if(size>=capacity)
            {
                // we need to resize
                int[] tempArray = new int[capacity * SCALE_FACTOR];

                for(int i=0;i<size;i++)
                {
                    tempArray[i]=entries[i];
                }

                capacity = capacity * SCALE_FACTOR;
                entries = tempArray;
            }

            // add element at end
            entries[size++] = element;
            tail = size - 1;
        }

        public int dequeue()
        {
            // empty queue
            if(size==0)
            {
                return -1;
            }

            int dequeueElement = entries[head];

            // now shift all element from right to left as we remove element from head
            for(int i=head;i<tail;i++)
            {
                entries[i] = entries[i+1];
            }

            entries[tail--]=0;
            size = size - 1;

            return dequeueElement;
        }

        public String toString()
        {
            StringBuilder sc = new StringBuilder();
            sc.append("[");
            for(int i=0;i<size;i++)
            {
                sc.append(entries[i]);
                sc.append(",");
            }

            sc.append("]");
            return sc.toString();
        }

    }
}
