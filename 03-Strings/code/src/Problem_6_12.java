import java.util.Scanner;

public class Problem_6_12 {

    // IMPLEMENT RUN-LENGTH ENCODING

    // Implement run-length encoding and decoding functions. Assume the string to be
    //encoded consistsof letters of the alphabet, with no digits, and the string to be decoded
    //is a valid encoding.

    // For example, the RLE
    //of "aaaabcccaa" is "4alb3c2a". The decoding of "3e4f2e" returns "eeeffffee"

    // In both Time and space 0(n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String for encoding : ");
        String forEncoding = sc.next();

        System.out.println("After encoding "+forEncoding+" : "+encodeS(forEncoding));

        System.out.print("Enter String for decoding : ");
        String forDecoding = sc.next();

        System.out.println("After encoding "+forDecoding+" : "+decodeS(forDecoding));
    }

    private static String decodeS(String s)
    {

        StringBuilder ans = new StringBuilder();


        for (int i = 0; i < s.length()-1; i=i+2) {

            int occurence = s.charAt(i) - '0';
            char currentChar = s.charAt(i+1);

            for(int j=1;j<=occurence;j++)
            {
                ans.append(currentChar);
            }
        }

        return ans.toString();
    }

    private static String encodeS(String s)
    {
        int count = 1;
        char currentChar = s.charAt(0);

        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {

            if(currentChar == s.charAt(i))
            {
                count++;
            }
            else
            {
                ans.append(count);
                ans.append(currentChar);
                currentChar = s.charAt(i);
                count=1;
            }

        }

        ans.append(count);
        ans.append(currentChar);

        return ans.toString();

    }

}
