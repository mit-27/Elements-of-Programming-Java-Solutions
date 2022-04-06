public class Problem_4_1 {

    // Compute parity of 1
    // if 1s is odd in n's bits then it means parity is 1 otherwise 0

    public static void main(String[] args) {

        int paritybit = parityBitOptimized(8);
        System.out.println(paritybit);

    }

    // Time complexity = 0(n) where n is bits of n
    public static int parityBit(long n) {
        int count = 0;
        while(n>0){
            // to get last bit of n
            int lastbit = (int)(n & 1);

            // to check even or odd we use xor as it gives 1^0 =1 and 1^1=0
            count = count ^ lastbit;
            n = n>>1;
        }
        return count;
    }

    // Time complexity = 0(k) where k is no of set bits in n
    public static int parityBitOptimized(long n) {
        int count = 0;
        while(n>0){
            // Here n&(n-1) will unset lowest set bit
            n = n & (n-1);

            // to check even or odd we use xor as it gives 1^0 =1 and 1^1=0
            count = count ^ 1;

        }
        return count;
    }

    // Time complexity = 0(log(n)) where n is no of bits in n
    // everytime when we do xor we divide it in two half and do xor between those two
    public static int parityBitLogn(long n) {
        n = n ^ (n>>32);
        n = n ^ (n>>16);
        n = n ^ (n>>8);
        n = n ^ (n>>4);
        n = n ^ (n>>2);
        n = n ^ (n>>1);

        return (int)(n ^ 1);

    }

}
