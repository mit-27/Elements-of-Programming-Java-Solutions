import java.util.HashMap;

public class Problem_4_3 {

    // Reverse bits for only 8 bits

    // lookeup table
    static HashMap<Integer,Integer> lookupTable;




    public static void main(String[] args) {

        lookupTable = new HashMap<Integer,Integer>();



        lookupTable.put(new Integer(3),new Integer(3));
        lookupTable.put(new Integer(2),new Integer(1));
        lookupTable.put(new Integer(0),new Integer(0));
        lookupTable.put(new Integer( 1),new Integer( 2));



        System.out.println(reverseBit(147));

    }

    public static int reverseBit(int n) {


        int maskSize = 2;
        int bitmask = 3;
        return (lookupTable.get(new Integer(((n & bitmask)))) << (maskSize*3) |
                lookupTable.get(new Integer(((n>>maskSize)&bitmask))) << (maskSize*2)
                | lookupTable.get(new Integer(((n>>(maskSize*2))&bitmask))) << (maskSize)
                | lookupTable.get(new Integer((n>>(maskSize*3)) & bitmask))
        );
    }
}
