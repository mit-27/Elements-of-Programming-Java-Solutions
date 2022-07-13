import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_10_7 {

    // Implementing a Stack API and Queue API using Heap

    // Push pop and enqueue and dequeue take logn time

    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(0);
        System.out.println("After pop : "+s.pop());

        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(0);
        System.out.println("After Dequeue : "+queue.dequeue());

    }

    static class EntryWithRank{
        public Integer timestamp,val;

        public EntryWithRank(Integer timestamp,Integer val)
        {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    static class Stack {
        Integer timestamp=0;

        // For stack use maxHeap
        PriorityQueue<EntryWithRank> maxHeap = new PriorityQueue<>(new Comparator<EntryWithRank>() {
            @Override
            public int compare(EntryWithRank e1, EntryWithRank e2) {
                return Integer.compare(e2.timestamp,e1.timestamp);
            }
        });

        public void push(int val)
        {
            maxHeap.add(new EntryWithRank(timestamp++,val));
        }

        public int pop()
        {
            return maxHeap.poll().val;
        }

        public int peek()
        {
            return maxHeap.peek().val;
        }
    }

    static class Queue {
        Integer timestamp=0;

        // For stack use maxHeap
        PriorityQueue<EntryWithRank> minHeap = new PriorityQueue<>(new Comparator<EntryWithRank>() {
            @Override
            public int compare(EntryWithRank e1, EntryWithRank e2) {
                return Integer.compare(e1.timestamp,e2.timestamp);
            }
        });

        public void enqueue(int val)
        {
            minHeap.add(new EntryWithRank(timestamp++,val));
        }

        public int dequeue()
        {
            return minHeap.poll().val;
        }

        public int peek()
        {
            return minHeap.peek().val;
        }
    }
}
