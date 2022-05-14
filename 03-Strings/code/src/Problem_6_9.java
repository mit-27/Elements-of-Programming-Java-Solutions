import java.util.HashMap;
import java.util.Scanner;

public class Problem_6_9 {

    // CONVERT FROM ROMAN TO DECIMAL

    // The Roman numeral representation of positive integers uses the symbols
    //I,V, X,L, C,D,M. Each symbol represents a value, with I being 1, V being 5, X being
    //10, L being 50, C being 100, D being 500, and M being 1000.

    // In this problem we give simplified rules for representing numbers in this system.
    //Specifically, define a string over the Roman number symbols to be a valid Roman
    //numberstringif symbolsappear in nonincreasing order, with thefollowing exceptions
    //allowed:
    //• I can immediately precede V and X.
    //• X can immediately precede L and C.
    //• C can immediately precede D and M
    // Back-to-back exceptions are not allowed, e.g., IXC is invalid, as is CDM.

    // A valid complex Roman number string represents the integer which is the sum
    //of the symbols that do not correspond to exceptions; for the exceptions, add the
    //difference of the larger symbol and the smaller symbol.

    // Write a program which takes as input a valid Roman number string s and returns the
    //integer it corresponds to.

    static HashMap<Character,Integer> charValues = new HashMap<Character,Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roman String to convert it into Integer : ");

        String roman = sc.next();

        System.out.println(convertRomanToInteger(roman));

    }

    private static boolean checkValidityOfRoman(String roman)
    {
        if(roman.length()==1)
        {
            return true;
        }

        // Flag to trace two consecutive exception
        int flag=0;

        for (int i = 1; i < roman.length(); i++) {

            if(flag>=2)
            {
                return false;
            }

            if(charValues.get(roman.charAt(i)) > charValues.get(roman.charAt(i-1)))
            {
                // Here we check exception validity

                // for IV and IX
                if((roman.charAt(i)=='V' || roman.charAt(i)=='X') && roman.charAt(i-1)=='I')
                {
                    flag++;
                }
                // XL and XC
                else if((roman.charAt(i)=='L' || roman.charAt(i)=='C') && roman.charAt(i-1)=='X')
                {
                    flag++;
                }
                // CD and CM
                else if((roman.charAt(i)=='D' || roman.charAt(i)=='M') && roman.charAt(i-1)=='C')
                {
                    flag++;
                }
                else
                {
                    // not any above of that it means i and i-1 chars not follows exception rules so invalid roman
                    return false;
                }
            }
            else {
                // reset flag to not include non-consecutive
                flag=0;
            }
        }

        if(flag>=2)
        {
            return false;
        }
        return true;

    }

    // Time : 0(n)
    private static int convertRomanToInteger(String roman)
    {
        // check validity of roman string
        if(!checkValidityOfRoman(roman))
        {
            return -1;
        }

        if(roman.length()==1)
        {
            return charValues.get(roman.charAt(0));
        }

        int convertedNumber = 0;

        // first store first char value
        convertedNumber+= charValues.get(roman.charAt(0));

        for (int i = 1; i < roman.length(); i++) {

            // mostly chars are in decreasing value order
            // but if it is not than it comes in exception where i have to add difference between those two char values
            // For example XL where x<L so add x-L in Integer conversion


            if(charValues.get(roman.charAt(i)) > charValues.get(roman.charAt(i-1)))
            {
                // Here we add difference for exp XL at L we remove X then add (L-X)

                convertedNumber= convertedNumber - charValues.get(roman.charAt(i-1)) + (charValues.get(roman.charAt(i)) - charValues.get(roman.charAt(i-1)))  ;
            }
            else
            {
                convertedNumber+= charValues.get(roman.charAt(i));
            }
        }

        return convertedNumber;

    }



}
