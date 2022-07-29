import java.util.*;

public class Problem_11_2 {

    // SEARCH A SORTED ARRAY FOR ENTRY EQUAL TO ITS INDEX

    // Design an efficient algorithm that takes a sorted array of distinct integers, and returns
    //an index i such that the element at index i equals i. For example, when the input is
    //(-2,0, 2, 3, 6, 7, 9) your algorithm should return 2 or 3

    public static void main(String[] args) {
        int[] arr = new int[]{0,4, 7, 8, 9, 10, 50};

        System.out.println(getEqualIndex(arr));

        int[] arr2 = new int[]{-2,0, 4, 4, 4, 10, 50};

        System.out.println(getEqualIndexInDuplicates(arr2));
    }

    // Time log(n)
    static int getEqualIndex(int[] arr)
    {
        int left=0,right=arr.length-1;

        while(left<=right)
        {
            int m = left + (right-left)/2;

            if(arr[m]==m)
            {
                // got ans
                return m;
            }
            else if(arr[m]>m)
            {
                // here val is higher than index so it means right side will have higher values compare to its indexes
                // so go right
                right = m-1;
            }
            else
            {
                left = m+1;
            }
        }

        return -1;
    }

    // TIme 0(n)
    static int getEqualIndexInDuplicates(int[] arr)
    {
       int currentIndex=0;

       while(currentIndex<arr.length)
       {
           // found ans
           if(arr[currentIndex]==currentIndex)
           {
               return currentIndex;
           }
           else if(arr[currentIndex]>currentIndex)
           {
               // it means arr[cuurentIndex] would be index where this value should be
               // so we jump there and if we find its great otherwise we look ahead after jump
               currentIndex = arr[currentIndex];
           }
           else
           {
               // as we covered from 0 to currentIndex and current val is lesser so we could no find value
               // so move ahead
               currentIndex++;
           }

       }

       return -1;



    }
}
