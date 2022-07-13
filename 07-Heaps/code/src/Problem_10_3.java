import java.util.*;

public class Problem_10_3 {

    // SORT AN ALMOST-SORTED ARRAY

    // Write a program which takes as input a very long sequence of numbers and prints
    //the numbers in sorted order. Each number is at most k away from its correctly sorted
    //position. (Such an array is sometimes referred to as being k-sorted )
    //For example, no
    //number in the sequence (3,-1,2,6,4,5,8} is more than 2 away from its final sorted
    //position.

    public static void main(String[] args) {

        int[] arr = new int[]{3,-1,2,6,4,5,8};

        // k which specifies no more than k away from its final position in array
        int k=2;

        System.out.println(sortAlmostSortedArray(arr,2));



    }

    // Time nlogK
    static List<Integer> sortAlmostSortedArray(int[] arr,int k)
    {
        // we use min-heap and pop it when heap size is >k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return Integer.compare(v1,v2);
            }
        });

        List<Integer> ans = new ArrayList<>();

        for(Integer n : arr)
        {
            // if ith element right position differ max at k from its current so
            if(minHeap.size()>=(k+1))
            {
                ans.add(minHeap.poll());
            }

            minHeap.add(n);
        }

        // add remaining minHeap elements
        while(minHeap.size()!=0)
        {
            ans.add(minHeap.poll());
        }

        return ans;


    }
}
