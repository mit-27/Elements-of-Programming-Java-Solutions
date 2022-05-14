import java.util.Scanner;

public class Problem_6_1 {

    // INTERCONVERT STRINGS AND INTEGERS

    // Implement string/integer inter-conversion functions.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // For string to int
        String s = sc.next();
        int intOfS = stringToInt(s);
        System.out.println(intOfS);

        // For int to String
        int x = sc.nextInt();
        String xString = intToString(x);
        System.out.println("String of x : "+xString);




    }

    // Time 0(log10(n)) where log10(n) is no of digits in n
    private static String intToString(int n)
    {
        StringBuilder s = new StringBuilder();
        if(n<0)
        {
            s.append("-");
            n = n * (-1);
        }
        int numberOfDigits = (int)Math.log10(n) + 1;

        int divider = (int)Math.pow(10,numberOfDigits-1);

        // Get digits from left to right
        for (int i = 1; i <= numberOfDigits; i++) {
            int digit = n/divider;
            n = n % divider;
            divider = divider/10;
            s.append(digit);
        }

        return s.toString();
    }

    // Time 0(k) where k is length of string s
    private static int stringToInt(String s)
    {
        boolean isNegative = false;
        int initialIndex=0;
        if(s.charAt(0)=='-')
        {
            isNegative=true;
            initialIndex++;
        }
        int ans=0;

        for (int i = initialIndex; i < s.length(); i++) {

            ans = ans * 10 + (int)(s.charAt(i)-'0');
        }

        if(isNegative){
            ans = ans * (-1);
        }

        return ans;
    }
}
