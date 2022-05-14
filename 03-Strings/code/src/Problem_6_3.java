public class Problem_6_3 {

    // COMPUTE THE SPREADSHEET COLUMN ENCODING

    // Implement a function that converts a spreadsheet column id to the corresponding
    //integer, with "A" corresponding to 1. For example, you should return 4 for "D", 27
    //for "AA", 702 for "ZZ", etc.

    public static void main(String[] args) {

        String id = "AA";
        System.out.println(columnEncoding(id));

    }

    // Time : 0(n) where n is length of id
    private static int columnEncoding(String id)
    {
        int ans = 0;

        // Power to incremnt from right to left
        int pow = 0;
        for (int i = id.length()-1; i >=0 ; i--) {
            int intFromAlphabet = id.charAt(i) - 'A' + 1;

            ans+= (int)(Math.pow(26,pow)) * intFromAlphabet;

            pow++;
        }

        return ans;
    }
}
