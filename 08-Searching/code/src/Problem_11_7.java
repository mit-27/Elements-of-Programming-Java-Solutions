import java.util.Arrays;

public class Problem_11_7 {

    // FIND THE MIN AND MAX SIMULTANEOUSLY

    // Design an algorithm to find the min and max elements in an array. For example, if
    //A = (3, 2, 5,1, 2, 4), you should return 1for the min and 5 for the max.

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,1,2,4};

        // We will return array {min,max}
        System.out.println(Arrays.toString(getMinMax(arr)));


    }

    // Time 0(n) and space is constant
    static int[] getMinMax(int[] arr)
    {
        if(arr.length==1)
        {
            return new int[]{arr[0],arr[0]};
        }

        // global min and max for track ans
        int globlaMin,globalMax;

        // store result after comparing first two pairs of arr
        if(arr[0]>arr[1])
        {
            globalMax=arr[0];
            globlaMin=arr[1];
        }
        else
        {
            globalMax=arr[1];
            globlaMin=arr[0];
        }

        // now iterate loop in two pairs
        for (int i = 2; i+1 <arr.length ; i=i+2) {
            // get local min and max
            int localmin,localMax;

            if(arr[i]>arr[i+1])
            {
                localMax=arr[i];
                localmin=arr[i+1];
            }
            else
            {
                localMax=arr[i+1];
                localmin=arr[i];
            }

            // after getting local min,max compares with global minmax
            if(localMax>globalMax)
            {
                globalMax=localMax;
            }

            if(localmin<globlaMin)
            {
                globlaMin=localmin;
            }
        }

        // now if arr length is odd then above loop will neglect last element so we have to compare that element with
        // globlaMinmax

        if(arr.length%2!=0)
        {
            if(arr[arr.length-1]>globalMax)
            {
                globalMax=arr[arr.length-1];
            }

            if(arr[arr.length-1]<globlaMin)
            {
                globlaMin=arr[arr.length-1];
            }
        }

        return new int[]{globlaMin,globalMax};
    }


}
