public class Problem_4_8 {

    // Reverse the digit

    public static void main(String[] args) {
        int x = 342;

        System.out.println(reverseDigit(x));
    }

    // Time = 0(n)
    private static int reverseDigit(int x) {

        int tempX= Math.abs(x);
        int reverse=0;

        while(tempX>0)
        {
            // Get rightmost digit and multiply with 10 to add that digit in reverse
            reverse = (reverse * 10) + tempX%10;
            tempX = tempX/10;
        }

        return x < 0 ? -reverse : reverse;

    }

}
