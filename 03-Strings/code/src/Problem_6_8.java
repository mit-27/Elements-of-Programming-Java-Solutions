import java.util.Scanner;

public class Problem_6_8 {

    //  THE LOOK-AND-SAY PROBLEM

    // The look-and-say sequence starts with 1. Subsequent numbers are derived by de¬
    //scribing the previous number in terms of consecutive digits. Specifically, to generate
    //an entry of the sequence from the previous entry, read off the digits of the previ¬
    //ous entry, counting the number of digits in groups of the same digit. For exam¬
    //ple, 1; one 1; two Is; one 2 then one 1; one 1, then one 2, then two Is; three Is,
    //then two 2s, then one 1. The first eight numbers in the look-and-say sequence are
    //<1,11, 21,1211,111221,312211,13112221,1113213211>

    // Write a program that takes as input an integer n and returns the nth integer in the
    //look-and-say sequence. Return the result as a string.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(getNthNumber(n));

    }

    // Time : 0(n * 2^n)
    private static String getNthNumber(int n)
    {
        StringBuilder currentNumber = new StringBuilder();
        currentNumber.append(1);
        if(n==1)
        {
            return currentNumber.toString();
        }
        int currentPosition = 1;
        int currentIndex = 0;
        int currentDigit=0;
        while(currentPosition!=n)
        {
            int currentNumberCount = 0;
            StringBuilder nextNumber = new StringBuilder();


            for (int i = 0; i < currentNumber.length(); i++) {
                int digit = currentNumber.charAt(i) - '0';

                // To save currentIndex digit for future comparison
                if(currentNumberCount==0)
                {
                    currentDigit=digit;
                }

                // If same digit then increment numberCount
                if(currentDigit==digit)
                {
                    currentNumberCount++;

                }

                if(currentDigit!=digit && currentNumberCount!=0)
                {
                    // now add to nextNumber and reset currentDigit and currentCount
                    nextNumber.append(currentNumberCount);
                    nextNumber.append(currentDigit);

                    // resetting currentDigit and count
                    currentDigit = digit;
                    currentNumberCount=1;
                }
            }

            // last digit and count remain to add in nextNumber so add it here
            nextNumber.append(currentNumberCount);
            nextNumber.append(currentDigit);

            currentNumber = new StringBuilder(nextNumber);

            currentPosition++;
        }

        return currentNumber.toString();
    }
}

