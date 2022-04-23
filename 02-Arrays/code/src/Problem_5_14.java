import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem_5_14 {

    // Compute random Permutation

    // for n=4 it could be (0,1,3,2)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i;
        }

        randomPermutation(arr);

        System.out.println(Arrays.toString(arr));



    }

    // Time = 0(n)
    private static void randomPermutation(int[] arr) {
        Random ran = new Random();

        for (int i = 0; i < arr.length; i++) {
            int guess = i+ran.nextInt(arr.length-i);

            // swap i and guess index
            int t = arr[i];
            arr[i] = arr[guess];
            arr[guess]= t;
        }

    }
}
