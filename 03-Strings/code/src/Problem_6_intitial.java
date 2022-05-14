import java.util.Scanner;

public class Problem_6_intitial {

    // check whether string is palindrome or not


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        s=s.trim();

        System.out.println("Entered String "+s+" is Palindrome : "+isStringPalindrome(s));

    }

    // Time 0(n) and space 0(1)
    private static boolean isStringPalindrome(String s)
    {
        int start=0;
        int end = s.length()-1;

        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
