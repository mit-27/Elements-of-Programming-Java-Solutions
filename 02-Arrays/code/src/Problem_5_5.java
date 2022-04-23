import java.util.Arrays;

public class Problem_5_5 {

    // DELETE DUPLICATES FROM A SORTED ARRAY

    // Write a program which takes as input a sorted array and updates it so that all dupli¬
    //cates have been removed and the remaining elements have been shifted left to fill the
    //emptied indices.

    public static void main(String[] args) {

        int[] arr = {2,3,5,5,7,11,11,11,13};
        int[] ans = deleteDuplicates(arr);
        System.out.println(Arrays.toString(ans));

    }

    // Time = 0(n)
    private static int[] deleteDuplicates(int[] arr)
    {
        // To track unique element
        int uniqueElementIndex = 0;

        if(arr.length==1)
        {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {

            if(arr[i]!=arr[i-1])
            {
                if(uniqueElementIndex!=(i-1))
                {
                    // if uE and i-1 is not same then increment uE and assign i which is next unique element
                    arr[++uniqueElementIndex] = arr[i];

                }
                else
                {
                    // if uE and i-1 is same then increment uE with i
                    uniqueElementIndex++;
                }
            }

        }

        for(int i=uniqueElementIndex+1;i<arr.length;i++)
        {
            arr[i]=0;
        }


        return arr;
    }

}
