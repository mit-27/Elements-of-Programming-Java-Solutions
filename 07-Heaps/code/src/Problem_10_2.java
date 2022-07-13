import java.util.*;

public class Problem_10_2 {

    // SORT AN INCREASING-DECREASING ARRAY

    // Design an efficient algorithm for sorting a fc-increasing-decreasing array.

    public static void main(String[] args) {

        int[] kthIncDescArray = new int[]{57, 131, 493, 294, 221, 339, 418, 458, 442, 190};


        System.out.println(sortkIncreaseDecreaseArray(kthIncDescArray));
    }

    // Time 0(nlogk)
    static List<Integer> sortkIncreaseDecreaseArray(int[] arr)
    {
        // first decompose arrays which are sorted in increasing with direct and reverse the descreasing

        // set flag to inc as it will start with increasing order
        boolean incOrder = true;

        List<List<Integer>> sortedSubArrays = new ArrayList<>();

        // we will use startIndex as start point of subarrays which we want to store in subArrays
        int startIndex = 0;

        for(int i=1;i<=arr.length;i++)
        {
            if(
                    (i==arr.length)
                    || (arr[i-1]>arr[i] && incOrder)
                    || (arr[i-1]<=arr[i] && !incOrder)
            )
            {
                // now we extract startIndex to i-1
                List<Integer> subList = new ArrayList<>();

                if(incOrder)
                {
                    // we add to subList from startIndex to i-1
                    int temp = startIndex;
                    while(temp < i)
                    {
                        subList.add(arr[temp++]);
                    }
                }
                else
                {
                   // we add to suList from i-1 to startIndex so it will be in increasing order
                    int temp = i-1;
                    while(temp >= startIndex)
                    {
                        subList.add(arr[temp--]);
                    }
                }

                // now add this sublist to sortedArrays
                sortedSubArrays.add(subList);

                // now change incOrder
                incOrder = !incOrder;

                // shift startIndex to i
                startIndex=i;

            }
        }

        // Now use 10_1 Solution as current array converted into subSortedArrays

        return Problem_10_1.mergeSortedArrays(sortedSubArrays);




    }
}
