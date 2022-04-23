import java.util.Arrays;

public class Problem_5_8 {

    // Rearrange array Elements like B[0]<=B[1]>=B[2]<=B[3]>=B[4]<=B[5]

    public static void main(String[] args) {

        int[] a = {7,2,3,8,5,1};
        rearrangeArray(a);
        System.out.println("After rearrange : "+ Arrays.toString(a));

    }

    // Time = 0(n)
    private static void rearrangeArray(int[] arr)
    {
        // After observing pattern
        // For even i it should arr[i]<=arr[i+1]
        // For odd i it should arr[i]>=arr[i+1]

        for (int i = 0; i < arr.length-1; i++) {

            if(i%2==0 && arr[i]>arr[i+1])
            {
                // Swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
            }

            if(i%2!=0 && arr[i]<arr[i+1])
            {
                // Swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
            }



        }

    }
}
