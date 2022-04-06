public class Problem_4_9 {
    
    // Check number is palindrone or not

    public static void main(String[] args) {
        int x = 343;

        System.out.println(isPalindrome(x));
    }

    // Time = 0(n) where n is no of digits in x
    private static boolean isPalindrome(int x) {

        // Find no of digits
        int noOfDigits = (int)Math.floor(Math.log10(x))+1;

        // divider to remove most significant digit of x
        int msdRemover = (int)Math.pow(10,noOfDigits-1);

        for(int i=0;i<(noOfDigits/2);i++)
        {
            if((x/msdRemover)!=(x%10))
            {
                return false;
            }
            x = x%msdRemover; // Remove most significant digit
            x = x/10; // Remove least significant digit
            msdRemover = msdRemover/100; // as we remove least significant digit

        }

        return true;

    }
}
