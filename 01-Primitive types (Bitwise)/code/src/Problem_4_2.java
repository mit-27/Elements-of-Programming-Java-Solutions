public class Problem_4_2 {

    // Swap bits

    public static void main(String[] args) {
        System.out.println(swapBits(73,0,6));

    }

    // Time complexity = 0(1)
    public static long swapBits(long n,int i,int j) {

        // if i and jth bits are same then no need to swap
        if((((n>>i)&1) ^ ((n>>j)&1)) == 0) {
            // if both same then xor gives 0
            return n;
        }

        // create mask for xor
        long mask = (long)((1<<i) | (1<<j)); // For example i=1 and j=3 then mask = 0001010

        return mask ^ n;


    }

    // 10100 & ~(10011) = 10100 & 01100 = 00100
}
