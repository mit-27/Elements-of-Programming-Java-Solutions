public class Problem_11_10 {

    // FIND THE DUPLICATE AND MISSING ELEMENTS

    // You are given an array of n integers, each between 0 and n -1, inclusive. Exactly
    //one element appears twice, implying that exactly one number between 0 and n -1
    //is missing from the array. How would you compute the duplicate and missing
    //numbers?

    public static void main(String[] args) {

        int[] arr = new int[]{5,3,0,3,1,2};
        System.out.println(findDuplicateMissing(arr));

    }

    private static class DuplicateAndMissing {
        public Integer duplicate;
        public Integer missing ;

        public DuplicateAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }

        public String toString()
        {
            return "{ Duplicate : "+duplicate+" , Missing : "+missing+" }";
        }
    }

    // Time 0(n)
    public static DuplicateAndMissing findDuplicateMissing(int[] arr)
    {
        // do xor of all entries of arr and also do 0 to arr.length so we found missingXORDuplicate
        int missXORDuplicate = 0;
        for(int i=0;i<arr.length;i++)
        {
            missXORDuplicate ^= i ^ arr[i];
        }

        // We need to find a bit that’s set to 1 in missXORDup. Such a bit
        // must exist if there is a single missing number and a single duplicated
        // number in A .

        // The bit- fiddling assignment below sets all of bits in differBit to SI
        // except for the least significant bit in missXORDup that’s 1.

        int differBit = missXORDuplicate & (~(missXORDuplicate - 1));
        int missOrDup = 0;

        for(int i=0;i<arr.length;i++)
        {
            // do xor with missorDup when differeth bit is 1
            // check in 0 to arr.length
            if((i & differBit) != 0)
            {
                missOrDup ^= i;
            }

            // check in arr entries
            if((arr[i]&differBit)!=0)
            {
                missOrDup ^= arr[i];
            }
        }

        // missOrDup is either the missing value or the duplicated entry.
        for (int a : arr) {
            if (a == missOrDup) { // missOrDup is the duplicate.
                return new DuplicateAndMissing(missOrDup , missOrDup ^ missXORDuplicate);
            }
        }
// missOrDup is the missing value.
        return new DuplicateAndMissing(missOrDup ^ missXORDuplicate, missOrDup);

    }


}
