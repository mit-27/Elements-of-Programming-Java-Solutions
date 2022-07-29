import java.util.Arrays;

public class Problem_11_1 {

    // SEARCH A SORTED ARRAY FOR FIRST OCCURRENCE OF k

    // Write a method that takes a sorted array and a key and returns the index of the
    //first occurrence of that key in the array.

    public static void main(String[] args) {
        int[] arr = new int[]{-14,-10,2,108,108,243,285,285,285,401};

        System.out.println(getFirstOccurenceOfK(arr,108));

        int[] arrVariant = new int[]{1,2,2,4,4,4,7,11,11,13};

        System.out.println(Arrays.toString(variantSearch(arrVariant,4)));
    }


    // Time 0(logn)
    static int getFirstOccurenceOfK(int[] arr,int key)
    {
        int left=0,right=arr.length-1;
        // if we didn't find then default result should be -1
        int result=-1;

        while(left<=right)
        {
            int m = left + (right-left)/2;

            if(arr[m]==key)
            {
                result = m;
                // now we found key so first occurence should be at left side
                right = m-1;
            }
            else if(arr[m]<key)
            {
                left = m+1;
            }
            else
            {
                right = m-1;
            }
        }

        return result;

    }

    // To get range of index of key in arr
    static int[] variantSearch(int[] arr,int key)
    {
        int left=0,right=arr.length-1;
        // if we didn't find then default result should be -1
        int leftBoundary=-1;
        int rightBoundary=-1;

        // For left boundary which is first occurent of key
        while(left<=right)
        {
            int m = left + (right-left)/2;

            if(arr[m]==key)
            {
                leftBoundary = m;
                right = m-1;
            }
            else if(key>arr[m])
            {
                left = m+1;
            }
            else
            {
                right = m-1;
            }
        }

        left = 0;
        right=arr.length-1;

        // For right boundary which is first occurent of key
        while(left<=right)
        {
            int m = left + (right-left)/2;

            if(arr[m]==key)
            {
                rightBoundary = m;
                left = m+1;
            }
            else if(key>arr[m])
            {
                left = m+1;
            }
            else
            {
                right = m-1;
            }
        }


        // now return left and right bounary in array
        return new int[]{leftBoundary,rightBoundary};


    }
}
