import java.util.Arrays;
import java.util.Random;

public class Problem_5_12 {

    // Sample offline data

    // Implement an algorithm that takes as input an array of distinct elements and a size,
    //and returns a subset of the given size of the array elements. All subsets should be
    //equally likely. Return the result in input array itself

    public static void main(String[] args) {
        int[] arr = {1,5,4,3};

        System.out.println(Arrays.toString(randomSampling(arr,2)));


    }

    private static int[] randomSampling(int[] arr,int samplingSize) {
        int[] answer = new int[samplingSize];
        Random ran = new Random();

        for (int i = 0; i < samplingSize; i++) {
            int guess = i+ran.nextInt(arr.length-i);

            // swap i and guess index
            int t = arr[i];
            arr[i] = arr[guess];
            arr[guess]= t;
        }

        for (int i = 0; i < samplingSize; i++) {
            answer[i]=arr[i];
        }

        return answer;
    }
}
