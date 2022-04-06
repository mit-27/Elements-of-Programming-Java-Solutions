public class Problem_4_4 {

    // Find a closest integer with same weight (no of 1s in binary = weight)

    public static void main(String[] args) {
        System.out.println(sameBitCount(7));

    }

    public static int sameBitCount(int x) {
        // we have to find consecutive two right most bits which are different and swap them

        // to find we iterate from 0 to 63
        int i = 0;
        while(i<64)
        {
            if((x>>i & 1) != (x>>(i+1) & 1))
            {
                // find consecutive bits
                // for swap/alter use xor
                x  = x ^ (1<<i | 1<<(i+1));
                return x;
            }

            i+=2;
        }

        // if all 0s or 1s it means answer is not possible
        return -1;
    }
}
