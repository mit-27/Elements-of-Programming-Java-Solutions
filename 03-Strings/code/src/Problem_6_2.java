import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Scanner;

public class Problem_6_2 {

    // BASE CONVERSION

    // Write a program that performs baseconversion. The input isa string,aninteger b2,and
    //another integer b2. The string represents be an integer in base b2. The output should
    //be the string representing the integer in base b2. Assume 2 < b\,b2 < 16. Use "A" to
    //represent 10, "B" for 11, ...,and "F" for 15. (For example, if the string is "615", bx is 7
    //and b2 is13, then the result should be"1A7", since 6x72 +1x7+5
    //= 1X132 + 10X13+7.)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your number in base b1 : ");
        String num = sc.next();
        System.out.print("Enter your b1 : ");
        int b1 = sc.nextInt();
        System.out.print("Enter your b2 : ");
        int b2 = sc.nextInt();

        System.out.println("Your number in base "+b2+" is "+baseConversion(num,b1,b2));
    }

    // Time complexity : 0(nlogb2(b1)) where n is length of b1
    private static String baseConversion(String number,int b1,int b2)
    {
        long multiplier = 1;
        boolean isNegative = false;
        if(number.charAt(0)=='-')
        {
            isNegative=true;
        }
        long decimalNumber = 0;
        for (int i = number.length()-1; i >= (isNegative ? 1 : 0); i--) {
            int digit=0;

            if(number.charAt(i)>='0' && number.charAt(i)<='9')
            {
                digit = number.charAt(i) - '0';
            }
            else
            {
                // if its in A to F range which corresponds to 10 to 15
                digit = number.charAt(i) - 'A' + 10;
            }

            decimalNumber+= multiplier * digit;

            // increase power of multiplier as we go from right to left
            multiplier = multiplier * b1;
        }

        StringBuilder ans = new StringBuilder();
        while(decimalNumber>0)
        {
            int lastDigit = (int)decimalNumber%b2;

            if(lastDigit>=10)
            {
                // convert 10 to 15 to A to F
                // and add into ans
                int lastD = 'A' + (int)(lastDigit%10);
                ans.append((char)lastD);
            }
            else
            {
                ans.append(lastDigit);
            }

            decimalNumber/=b2;
        }

        if(isNegative)
        {
            ans.append('-');
        }

        ans.reverse();

        return ans.toString();

    }
}
