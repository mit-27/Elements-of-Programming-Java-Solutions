public class Problem_11_4 {

    // COMPUTE THE INTEGER SQUARE ROOT

    // Write a program which takes a nonnegative integer and returns the largest integer
    //whose square is less than or equal to the given integer. For example, if the input is
    //16, return 4; if the input is 300, return 17, since 172 = 289 < 300 and 182 = 324 > 300.

    public static void main(String[] args) {
        int k = 21;
        System.out.println(getSquareRoot(k));
    }

    // Time logk
    static int getSquareRoot(int k)
    {
        // current range is 0 to k-1
        int left = 0;
        int right = k-1;

        int ans=0;

        while(left<=right)
        {
            int m = left + (right-left)/2;

            if((m*m)>k)
            {
                // it means go to left side of m
                right = m-1;
            }
            else if((m*m)<k)
            {
                // it could possible that m is ans
                ans = m;
                // then go right for possible ans
                left = m+1;
            }
        }

        return ans;
    }
}
