import java.util.Scanner;

public class Problem_6_13 {

    // FIND THE FIRST OCCURRENCE OF A SUBSTRING

    // Given two strings s (the "search string") and t (the "text"), find the first occurrence of
    //s in t.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s : ");
        String s = sc.nextLine();
        System.out.print("Enter t : ");
        String t = sc.nextLine();

        System.out.println("Occurence of "+s+" in "+t+" : "+findOccurenceUsingRabinKarp(s,t));

    }

    // Using Rabin-Karp Algorithm Mostly in best case time: T(n-m+1) and in worst case which has low possibility T(mn)
    private static int findOccurenceUsingRabinKarp(String s,String t)
    {
        if(s.length()>t.length())
        {
            return -1;
        }

        // for hash we calculate like for exp abc = a*26^2 + b *26^1 + c *26^0
        int intialPower = s.length();
        int base = 26;
        int sHash = 0;
        int tHash = 0;
        for (int i=0;i<s.length();i++)
        {
            intialPower--;
            tHash += (t.charAt(i) * Math.pow(base,intialPower) % Integer.MAX_VALUE);
            sHash += (s.charAt(i) * Math.pow(base,intialPower) % Integer.MAX_VALUE);
        }

        // check at intial occurence
        if(tHash==sHash && (t.substring(0,s.length()).equals(s)))
        {
            // found a match
            return 0;
        }

        // now we start with s.length index in t as we already computed 0 to s.length-1
        for (int i = s.length(); i < t.length(); i++) {

            // change t hash based on current
            tHash -= (t.charAt(i-s.length()) * Math.pow(26,s.length()-1));
            tHash *= Math.pow(base,1);
            tHash = (tHash+ t.charAt(i)) % Integer.MAX_VALUE;

            // Now compare
            // for matched hashcodes and s in t
            if(tHash==sHash && (t.substring(i-s.length()+1,i+1).equals(s)))
            {
                // found a match
                return i - s.length()+1;
            }
        }

        return -1;
    }


    // Brute force Time 0(mn) where m is length of s and n is length of t
    private static int findOccurence(String s,String t)
    {
        if(s.length()>t.length())
        {
            return -1;
        }
        for (int i = 0; i < t.length(); i++) {
            // flag to check occurence of s
            boolean matchedSubString = true;
            int currentIndex = i;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)==t.charAt(currentIndex))
                {
                    currentIndex++;
                }
                else
                {
                    matchedSubString=false;
                    break;
                }
            }

            if(matchedSubString)
            {
                return i;
            }
        }

        return -1;

    }
}
