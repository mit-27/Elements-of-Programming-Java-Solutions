import java.util.*;

public class Problem_10_1 {

    // MERGE SORTED Arrays

    // Write a program that takes as input a set of sorted sequences and computes the union
    //of these sequences as a sorted sequence. For example, if the input is (3,5,7), (0,6),
    //and (0,6, 28), then the output is (0, 0,3,5,6,6, 7, 28).

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>(Arrays.asList(3,5,7));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(0,6));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(0,6,28));

        List<List<Integer>> sortedArrays = new ArrayList<>();
        sortedArrays.add(l1);
        sortedArrays.add(l2);
        sortedArrays.add(l3);

        System.out.println("After merging : "+mergeSortedArrays(sortedArrays));

    }

    public static class ArrayEntry{
        public Integer value,arrayId;

        public ArrayEntry(Integer value,Integer arrayId)
        {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    // Time Complexity : 0(nlog(k)) here k is num of arrays because at a time max k elements would be in minHeap so
    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays)
    {
        // make list iterator so we can iterate all sorted arrays
        List<Iterator<Integer>> iter = new ArrayList<>(sortedArrays.size());

        // add all sorted array's iterator in above list of iterators
        for(List<Integer> array : sortedArrays)
        {
            iter.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(((int) sortedArrays.size()), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry e1, ArrayEntry e2) {
                return Integer.compare(e1.value,e2.value);
            }
        });

        // now initially add first entry of each sorted arrays in minHeap
        for(int i=0;i<iter.size();i++)
        {
            if(iter.get(i).hasNext())
            {
                minHeap.add(new ArrayEntry(iter.get(i).next(),i));
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!minHeap.isEmpty())
        {
            // get min element from heap
            ArrayEntry headEntry = minHeap.poll();
            // add to ans
            ans.add(headEntry.value);

            // now go to next value of headEntry's array if it possible and add it to minheap
            if(iter.get(headEntry.arrayId).hasNext())
            {
                minHeap.add(new ArrayEntry(iter.get(headEntry.arrayId).next(), headEntry.arrayId));
            }
        }

        return ans;
    }
}
