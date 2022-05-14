import java.util.Arrays;

public class Problem_6_4_variant {

    // Write a program which merges two sorted arrays of integers, A and B.
    //Specifically, the final result should be a sorted array of length m + n, where n and
    //m are the lengths of A and B, respectively. Use 0(1) additional storage
    //—assume the
    //result is stored in A, which has sufficient space. These arrays are C-style arrays, i.e.,
    //contiguous preallocated blocks of memory

    public static void main(String[] args) {
        int[] A = {1,2,5,0,0,0};
        int[] B = {2,5,8};

        System.out.println(Arrays.toString(mergeArrays(A,B)));


    }

    // Time : 0(n) and space 0(1)
    private static int[] mergeArrays(int[] A,int[] B)
    {
        // set end pointer which assign bigger element and decrement index to accumulate next small element
        int lastIndex = A.length-1;

        // last index where elements are not 0
        int indexA = A.length - B.length -1;

        // last index of B
        int indexB = B.length -1;

        while((indexA>=0) && (indexB>=0))
        {
            //if A's last element bigger that b's last element then assign it in lastIndex and decrement it
            if(A[indexA]>=B[indexB])
            {
                A[lastIndex--]=A[indexA--];
            }
            else
            {
                A[lastIndex--]=B[indexB--];
            }
        }

        // If all B's array element assigned and A's remain then
        while(indexA>=0)
        {
            A[lastIndex--]=A[indexA--];
        }

        // If all A's array element assigned and B's remain then
        while(indexB>=0)
        {
            A[lastIndex--]=B[indexB--];
        }


        return A;



    }
}
