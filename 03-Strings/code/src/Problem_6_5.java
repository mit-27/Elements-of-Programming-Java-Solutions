import java.util.Scanner;

public class Problem_6_5 {

    // TEST PALINDROMICITY

    // Implement a function which takes as input a string s and returns true if s is a palin¬
    //dromic string. For example, "A man, a plan, a canal, Panama." and "Able was I, ere I saw
    //Elba!" are palindromic, but "Ray a Ray" is not.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String to check Palindromicity : ");
        String s = sc.nextLine();

        System.out.println(s+" is Palindrome : "+checkPalindromicity(s));

    }

    // Time 0(n) n is length of s and Space 0(1)
    private static boolean checkPalindromicity(String s){
        // use two pointer and compare its characters
        s = s.toLowerCase();
        int firstIndex = 0;
        int lastIndex = s.length()-1;

        while(firstIndex<lastIndex)
        {
            if(s.charAt(firstIndex)>='a' && s.charAt(firstIndex)<='z' && s.charAt(lastIndex)>='a' && s.charAt(lastIndex)<='z')
            {
                // it means both indexes have chars
                // so compare
                if(s.charAt(firstIndex)!=s.charAt(lastIndex))
                {
                    return false;
                }
                else
                {
                    // both are same then
                    firstIndex++;
                    lastIndex--;
                }
            }
            else
            {
                // if firstIndex do not have chars then increment it to get chars
                if(s.charAt(firstIndex)<'a' || s.charAt(firstIndex)>'z')
                {
                    firstIndex++;
                }
                // if lastIndex do not have chars then decrement it to get chars
                if(s.charAt(lastIndex)<'a' || s.charAt(lastIndex)>'z')
                {
                    lastIndex--;
                }
            }
        }

        return true;
    }
}
