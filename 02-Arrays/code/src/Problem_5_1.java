import java.util.Arrays;

public class Problem_5_1 {

    // Dutch National Flag Problem

    // Write a program that takes an array A and an index i into A, and rearranges the
    //elements such that all elements less than A[i] (the "pivot") appear first, followed by
    //elements equal to the pivot, followed by elements greater than the pivot.

    public static void main(String[] args) {

        int[] arr = {0,1,0,2,1,2,0,1,0,2};

        changeArr(arr);

        System.out.println(Arrays.toString(arr));


    }

    // Time : 0(n)
    private static void changeArr(int[] arr)
    {
        int pivot_lesser = 0;
        int pivot_bigger = arr.length-1;
        int i=0;
        int pivot = 1;



        while(i<=pivot_bigger)
        {
            if(arr[i]!=pivot)
            {
                // lesser than pivot
                if(arr[i]<pivot)
                {
                    int t = arr[i];
                    arr[i]=arr[pivot_lesser];
                    arr[pivot_lesser]=t;
                    pivot_lesser++;
                    i++;
                }
                else
                {
                    int t = arr[i];
                    arr[i]=arr[pivot_bigger];
                    arr[pivot_bigger]=t;
                    pivot_bigger--;
                }
            }
            else
            {
                i++;
            }


        }

    }
}
