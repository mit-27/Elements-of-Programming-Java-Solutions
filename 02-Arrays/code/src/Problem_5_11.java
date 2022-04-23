import java.util.Arrays;

public class Problem_5_11 {

    // COMPUTE THE NEXT PERMUTATION

    // Question : Write a program that takes as input a permutation, and returns the next permutation
    //under dictionary ordering. If the permutation is the last permutation, return the
    //empty array. For example, if the input is (1,0,3, 2) your function should return
    //(1, 2, 0, 3). If the input is (3, 2,1,0), return ().

    // Exp :
    //[1,0,3,2] => [1,2,0,3]
    // 123 132 213 231 312 321 = Permutations in order

    // (6,2,1,5, 4,3,0) => (6,2,3,0,1,4,5)
    // Explanation
    // For above example, from right to left we have to find max decreasing order which is suffix=(5,4,3,0) and
    // and before this there is e=1 so in next permutation e would change to its next increasing element
    // from suffix which is e=3 and after swap 1 with 3 and then arrange suffix in decreasing order to become minumum
    // next permutation


    public static void main(String[] args) {

        int[] forNextPermutation = {6,2,1,5, 4,3,0};

        System.out.println(Arrays.toString(nextPermutation(forNextPermutation)));

        int[] forPreviousPermutation = {1,3,2};


        System.out.println(Arrays.toString(previousPermutation(forPreviousPermutation)));


    }

    // Time = 0(n)
    private static int[] previousPermutation(int[] permutation)
    {
        // find suffix where i and j points to start and end of suffix

        int startSuffix = permutation.length-1;
        int endSuffix = permutation.length-1;

        // Find start of suffix which is in asc order from left to right
        for(int i=endSuffix;i>=0;i--)
        {
            if(i==0)
            {
                break;
            }

            if(permutation[i-1]<=permutation[startSuffix])
            {
                // decreasing order continue
                startSuffix--;
            }
            else
            {
                break;
            }
        }

        // For last permutation it is not possible to find next permutation
        if(startSuffix==0)
        {
            return new int[]{};
        }

        // set e
        int e = startSuffix-1;

        // Find k index where p[k] next lower element than p[e] which swap p[k] <-> p[e]
        int k=endSuffix;

        while(k>=startSuffix)
        {
            if(permutation[k]<permutation[e])
            {
                // swap p[k] and p[e]
                int temp = permutation[k];
                permutation[k] = permutation[e];
                permutation[e] = temp;

                break;
            }
            k--;
        }

        // now arrange new suffix after above swap in decreasing order
        while(startSuffix<=endSuffix)
        {
            int t = permutation[startSuffix];
            permutation[startSuffix]=permutation[endSuffix];
            permutation[endSuffix]=t;

            startSuffix++;
            endSuffix--;
        }

        return permutation;





    }


    // Time = 0(n)
    private static int[] nextPermutation(int[] permutation)
    {
        // find suffix where i and j points to start and end of suffix

        int startSuffix = permutation.length-1;
        int endSuffix = permutation.length-1;

        // Find start of suffix
        for(int i=endSuffix;i>=0;i--)
        {
            if(i==0)
            {
                break;
            }

            if(permutation[i-1]>=permutation[startSuffix])
            {
                // decreasing order continue
                startSuffix--;
            }
            else
            {
                break;
            }
        }

        // For last permutation it is not possible to find next permutation
        if(startSuffix==0)
        {
            return new int[]{};
        }

        // set e
        int e = startSuffix-1;

        // Find k index where p[k] next higher element than p[e] which swap p[k] <-> p[e]
        int k=endSuffix;

        while(k>=startSuffix)
        {
            if(permutation[k]>permutation[e])
            {
                // swap p[k] and p[e]
                int temp = permutation[k];
                permutation[k] = permutation[e];
                permutation[e] = temp;

                break;
            }
            k--;
        }

        // now arrange new suffix after above swap in increasing order
        while(startSuffix<=endSuffix)
        {
            int t = permutation[startSuffix];
            permutation[startSuffix]=permutation[endSuffix];
            permutation[endSuffix]=t;

            startSuffix++;
            endSuffix--;
        }

        return permutation;





    }

}
