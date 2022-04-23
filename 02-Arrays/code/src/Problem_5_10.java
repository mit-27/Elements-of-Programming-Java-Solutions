import java.util.Arrays;

public class Problem_5_10 {

    // Problem : PERMUTE THE ELEMENTS OF AN ARRAY

    // Given an array A of n elements and a permutation P, apply P to A.

    public static void main(String[] args) {

        int[] P = {2,0,1,3};
        int[] A= {1,5,2,3};
        permutation(P,A);

    }

    // Like Cyclic Sort approach
    // Time = 0(n)
    private static void permutation(int[] P,int[] A)
    {
//        int next;
        for(int i=0;i<A.length;i++)
        {

            int next=i;
            while(P[next]>=0)
            {
                // swap A[i] with A[P[next]]
                int t = A[i];
                A[i] = A[P[next]];
                A[P[next]] = t;

                // Save next cyclic next
                int temp = P[next];

                // Now we perform next make it marked with negative
                P[next] = P[next] - P.length;

                next = temp;
            }
        }

        // We again set Permutaton Array right
        for(int i=0;i<P.length;i++)
        {
            P[i]+=P.length;
        }

        System.out.println("After Permutation of P Array A : "+ Arrays.toString(A));

    }
}
