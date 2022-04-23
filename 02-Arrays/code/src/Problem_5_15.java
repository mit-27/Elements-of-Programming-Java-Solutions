import java.util.Arrays;
import java.util.Random;

public class Problem_5_15 {

    // COMPUTE A RANDOM SUBSET

    // similar to 5.12

    public static void main(String[] args) {

        int[] arr = {2,5,6,7,3,1};

        System.out.println(Arrays.toString(randomSubset(arr,2)));
    }


    // Time 0(k) and space 0(k)
    private static int[] randomSubset(int[] arr,int k)
    {
        Random ran = new Random();

        for (int i = 0; i < k; i++) {

            int replaceIndex = i + ran.nextInt(arr.length-i);

            // swap elements between i and replaceIndex
            int t = arr[i];
            arr[i]=arr[replaceIndex];
            arr[replaceIndex]=t;

        }

        // now store those first k elements from arr to ans
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i]=arr[i];
        }

        return ans;
    }




}
