import java.util.Arrays;
import java.util.Scanner;

public class Problem_6_6 {

    // REVERSE ALL THE WORDS IN A SENTENCE

    // Implement a function for reversing the words in a string s.
    // For example, "Alice likes Bob" transforms to "Bob likes Alice". We do not need to keep the original string.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // convert it into array as String is immutable in Java
        char[] arr = s.toCharArray();

        System.out.println("Ans : "+reverseWords(arr));

    }

    // Time 0(n) space 0(1)
    private static String reverseWords(char[] arr)
    {
        // first reverse whole sentence
        reverse(arr,0,arr.length-1);

        int startWordIndex = 0;
        int endWordIndex = 0;
        int currentIndex=0;
        while(startWordIndex<arr.length)
        {
            // find word startIndex
            while(arr[startWordIndex]==' ')
            {
                startWordIndex++;
            }

            // find word endIndex
            for (currentIndex = startWordIndex+1; currentIndex < arr.length; currentIndex++) {

                if(arr[currentIndex]==' ')
                {
                    break;
                }
            }
            endWordIndex = currentIndex-1;

            // now reverse word
            reverse(arr,startWordIndex,endWordIndex);

            startWordIndex = endWordIndex+1;
        }
//        System.out.println(Arrays.toString(arr));
        return String.copyValueOf(arr);
    }

    private static void reverse(char[] arr,int start,int end)
    {
        while(start<end)
        {
            // swap start and end index values
            char t = arr[start];
            arr[start]=arr[end];
            arr[end]=t;

            start++;
            end--;
        }

    }
}
