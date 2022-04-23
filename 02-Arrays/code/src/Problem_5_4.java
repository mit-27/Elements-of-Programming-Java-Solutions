public class Problem_5_4 {

    // ADVANCING THROUGH AN ARRAY
//    Write a program which takes an array of n integers, where A[i] denotes the maximum
//    you can advance from index i, and returns whether it is possible to advance to the
//    last index starting from the beginning of the array.

    public static void main(String[] args) {

        int[] arr = {3,3,1,0,2,0,1};
        System.out.println(minimumStepsAdvance(arr));
    }

    private static int minimumStepsAdvance(int[] arr)
    {
        int maxPosition = arr[0];
        if(arr.length==0)
        {
            return 0;
        }

        // For iteration
        int i=1;
        int count=1;
        while(i<=maxPosition)
        {
            if(i==(arr.length-1))
            {
                break;
            }

            // If in i to maxPosition you will get index where i+arr[i] > maxPosition then update maxPosition
            if((i+arr[i])>maxPosition)
            {
                maxPosition = i + arr[i];
                count++;
            }

            i++;

        }

        if(i==(arr.length-1))
        {
            return count;
        }
        return -1;
    }

    // Time = 0(n)
    private static boolean isAdvancePossible(int[] arr)
    {
        int maxPosition = arr[0];
        if(arr.length==0)
        {
            return true;
        }

        // For iteration
        int i=1;
        while(i<=maxPosition)
        {
            if(i==(arr.length-1))
            {
                return true;
            }

            // If in i to maxPosition you will get index where i+arr[i] > maxPosition then update maxPosition
            if((i+arr[i])>maxPosition)
            {
                maxPosition = i + arr[i];
            }

            i++;

        }

        return false;
    }
}
