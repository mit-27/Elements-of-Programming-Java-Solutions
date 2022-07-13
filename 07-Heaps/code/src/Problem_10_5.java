import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_10_5 {

    // COMPUTE THE MEDIAN OF ONLINE DATA

    // You want to compute the running median of a sequence of numbers. The sequence is
    //presented to you in a streaming fashion—you cannot back up to read an earlier value,
    //and you need to output the median after reading in each new element. For example,
    //if the input is 1,0,3, 5, 2, 0,1 the output is 1,0.5,1,2,2,1.5,1.
    // Design an algorithm for computing the running median of a sequence.

    public static void main(String[] args) {

        int[] arr = new int[]{1,0,3,5,2,0,1};

        System.out.println(Arrays.toString(getMedianArray(arr)));

    }

    // Time complexity per entry is logn
    static float[] getMedianArray(int[] arr)
    {
        // Use two heap (small-MaxHeap and large-minHeap) and track through divide current values in those two heaps

        // Small - MaxHeap
        // Large = MinHeap

        // Default is MinHeap
        PriorityQueue<Integer> large = new PriorityQueue<>();

        // MaxHeap
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return Integer.compare(v2,v1);
            }
        });

        float[] ans = new float[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            int val = arr[i];
            // Default add it to small
            small.add(val);

            // Now Its important to check below conditions in order

            // First small's values <= large's values
            // So if small max > large min then we have to transfer the value
            if(!small.isEmpty() && !large.isEmpty() && small.peek()>large.peek())
            {
                // transfer val from small to large
                large.add(small.poll());
            }

            // Now small and large size difference <=1 otherwise transfer values
            // check size difference
            if(Math.abs(small.size()-large.size())>1)
            {
                // check which is biggere and transfer from it to other
                if(small.size()>large.size())
                {
                    large.add(small.poll());
                }
                else
                {
                    small.add(large.poll());
                }
            }

            // now we will get median

            if(small.size()>large.size())
            {
                // small has one extra val so max from it would be median
                ans[i]=small.peek();
            }
            else if(large.size()>small.size())
            {
                // large has one extra val so min from it would be median
                ans[i]=large.peek();
            }
            else
            {
                // both are same then
                ans[i] = ((float)small.peek()+large.peek())/2;
            }


        }

        return ans;



    }
}
