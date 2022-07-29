import java.util.*;

public class Problem_11_9 {

    // FIND THE MISSING IP ADDRESS

    // Suppose you were given a file containing roughly one billion IP addresses, each of
    //which is a 32-bit quantity. How would you programmatically find an IP address that
    //is not in the file? Assume you have unlimited drive space but only a few megabytes
    //of RAM at your disposal.

    public static void main(String[] args) {

    }

    // Algo Steps ( As this is complex solution)
    // In Ip There are 16 MSB and 16 LSB
    // Get all 16 MSB with its combination as one of 16 MSB has <2^16 entries which is Missing IP
    // Now again get that 16 MSB which should have 1 missing IP and store its 16 LSB in array and check from 0 to 2^16
    // whatever you don't get from stored array which is missing IP

    private static final int NUM_BUCKET = 1 << 16;
    private static final int BIT_MASK_TO_GET_LOWER_16 = (1<<16)-1;

    public static int findMissingElement(Iterable<Integer> sequence)
    {
        // array to store each 16 MSB's all combination with lower 16 bits
        int[] counter = new int[NUM_BUCKET];

        Iterator<Integer> s = sequence.iterator();

        while(s.hasNext())
        {
            // We count how many times 16 MSB repeated which gives count of combination of that MSB with 16 LSB
            int idx = s.next() >> 16;
            ++counter[idx];
        }

        for (int i = 0; i < counter.length; i++) {
            // now find bucket which contains less than NUM_BUCKET as that would get to missing IP
            if(counter[i]<NUM_BUCKET)
            {
                // bool type array to check val of lower 16 msb
                BitSet bitVec = new BitSet(NUM_BUCKET);
                s= sequence.iterator(); // search from the beginning again
                while(s.hasNext())
                {
                    int x = s.next();
                    // get x's upper part and compare with curent upper which is i
                    int xUpperPart = x>>16;
                    if(i==xUpperPart)
                    {
                       bitVec.set(BIT_MASK_TO_GET_LOWER_16 & x);
                    }
                }

                // now find which is not in bitvec
                for (int j = 0; j < NUM_BUCKET; j++) {
                    if(!bitVec.get(j))
                    {
                        // combine j with i and return missing IP
                        return (i<<16) | j;
                    }
                }
            }
        }

        // if not missing IP
        return -1;
    }
}
