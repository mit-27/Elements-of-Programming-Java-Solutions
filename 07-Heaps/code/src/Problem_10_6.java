import java.util.*;

public class Problem_10_6 {

    // COMPUTE THE k LARGEST ELEMENTS IN A MAX-HEAP

    // Given a max-heap, represented asan array A,design an algorithm that computes the k
    //largest elementsstored in the max-heap. You cannot modify the heap. For example, if
    //the heap is the one shown in Figure11.1(a) on Page175, then the array representation
    //is (561, 314, 401, 28,156, 359, 271,11, 3), the four largest elements are 561,314, 401, and
    //359.

    public static void main(String[] args) {

        // Which is implemented using Binary Tree
        int[] maxHeapArr = new int[]{561, 314, 401, 28,156, 359, 271,11, 3};

        System.out.println(getKLargest(maxHeapArr,4));

    }

    static class HeapEntry{
        public Integer index,val;

        public HeapEntry(Integer val,Integer index)
        {
            this.index = index;
            this.val = val;
        }
    }

    // Time Complexity :  klogk
    static List<Integer> getKLargest(int[] arr,int k)
    {
        // Here we create another MaxHeap using HeapEntry
        PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(new Comparator<HeapEntry>() {
            @Override
            public int compare(HeapEntry e1, HeapEntry e2) {
                return Integer.compare(e2.val,e1.val);
            }
        });

        // first we add root which is at index 0
        maxHeap.add(new HeapEntry(arr[0],0));

        List<Integer> ans = new ArrayList<>();
        // Interate for k times
        for(int i=0;i<k;i++)
        {
            // store max element index
            int currentMaxElementIdx = maxHeap.peek().index;

            // now remove the max element and add it to ans
            ans.add(maxHeap.poll().val);

            // now add left and right child of curretMaxIndex in maxHeap if possible
            int leftChildIdx = currentMaxElementIdx * 2 + 1;
            int rightChildIdx = currentMaxElementIdx * 2 + 2;

            if(leftChildIdx< arr.length)
            {
                maxHeap.add(new HeapEntry(arr[leftChildIdx],leftChildIdx));
            }

            if(rightChildIdx < arr.length)
            {
                maxHeap.add(new HeapEntry(arr[rightChildIdx],rightChildIdx));
            }



        }

        return ans;

    }
}
