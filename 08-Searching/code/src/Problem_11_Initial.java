import java.util.*;

public class Problem_11_Initial {

    // Binary Search Initial

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};

        System.out.println(getIndex(arr,1));




    }

    static int getIndex(int[] arr,int target)
    {
        // Initialize start and end
        int start = 0;
        int end = arr.length-1;


        while(start<=end)
        {
            int middle = start + (end - start)/2;

            if(arr[middle]==target)
            {
                return middle;
            }
            else if(arr[middle]<target)
            {
                // go right side of array
                start = middle+1;
            }
            else
            {
                // go left side of array
                end = middle-1;
            }
        }

        return -1;
    }
}
