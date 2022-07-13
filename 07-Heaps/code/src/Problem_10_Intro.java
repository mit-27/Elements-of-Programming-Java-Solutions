import java.util.*;

public class Problem_10_Intro {

    // Its intro to Heap using simple problem

    // From list of Strings get top k longest strings

    public static void main(String[] args) {
        String[] s = {"M","msd","mm","canada","America"};

        System.out.println(topK(2,s));
    }

    static List<String> topK(int k,String[] arr)
    {
        // we will create minHeap so that when size of heap > k then we will remove and smallest one will removed
        // and new element added so that at the end we will get top k largest element which stored in heap

        // Here Heap == Priority Queue
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(),s2.length());
            }
        });

        // now iterate array
        for(String s : arr)
        {
            // add to heap
            minHeap.add(s);

            // check heap size
            if(minHeap.size() > k)
            {
                // Remove the shortest string
                // Here its minHeap so it will remove that
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}
