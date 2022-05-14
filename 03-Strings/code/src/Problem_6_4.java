import java.util.Arrays;

public class Problem_6_4 {

    // REPLACE AND REMOVE

    // Consider the following two rules that are to be applied to an array of characters.
    //• Replace each 'a' by two 'd's.
    //• Delete each entry containing a 'b'.
    //For example, applying these rules to the array (a,c,d,b,b,c,a) results in the array
    //(d,d,c,d,c,d,d).

    public static void main(String[] args) {
//        char[] arr = {'a','c','d','b','b','c','a'};
//        System.out.println(Arrays.toString(changedArray(arr)));
        char[] arr = {'a','b','c','a','a',' ',' ',' ',' '};
        System.out.println(optimizedSolution(arr.length,arr));
    }

    // For main solution we have to pass size and array and return finalSize of array after changes
    // Time 0(n) and space 0(1) - in this order is also maintained
    private static int optimizedSolution(int size,char[] arr) {
        int writeIndex = 0;
        int aCount = 0;

        // Iteration to remove b
        for (int i = 0; i < size; i++) {
            if(arr[i]!='b' && arr[i]!=' ')
            {
                arr[writeIndex++]=arr[i];
            }

            if(arr[i]=='a')
            {
                aCount++;
            }
        }

        System.out.println("After removing b array is "+Arrays.toString(arr));

        // now we replacing a with two d's
        // After this index all chars either empty or repeated
        int currentIndex = writeIndex-1;

        // d should be double of a so counted a already there in [0,writeIndex] so we have to add other half d using below
        // so we starting to add d from backwards
        writeIndex = currentIndex + aCount;

        // final size would be below
        int finalSize = currentIndex + aCount + 1;

        // adding two d's for a
        while(currentIndex>=0)
        {
            if(arr[currentIndex]=='a')
            {
                // add two d's
                arr[writeIndex--]='d';
                arr[writeIndex--]='d';

            }
            else
            {
                // if its not a then assign to writeindex so order would maintain for this element
                arr[writeIndex--]=arr[currentIndex];
            }
            currentIndex--;
        }

        System.out.println("Final array after two changes : "+Arrays.toString(arr));

        return finalSize;
    }


    // Time 0(n) and space 0(n) - Brute Force Solution
    private static char[] changedArray(char[] arr)
    {
        int newSize = 0;

        // To calculate size of answer array after changes
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='a')
            {
                newSize+=2;
            }
            else if(arr[i]=='b')
            {
                continue;
            }
            else
            {
                newSize++;
            }
        }

        char[] ans = new char[newSize];
        int ind=0;

        // adding entries in ans array
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='a')
            {
                // adding two d's when a encountered
                ans[ind++]='d';
                ans[ind++]='d';
            }
            else if(arr[i]=='b')
            {
                continue;
            }
            else
            {
                ans[ind++]=arr[i];
            }
        }

        return ans;

    }


}
