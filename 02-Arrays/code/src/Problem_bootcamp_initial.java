import java.util.Arrays;

public class Problem_bootcamp_initial {

    // Place even no left side and odd number right side

    public static void main(String[] args) {

        int[] ar = {3,2,5,4,8,7,9};
        orderArray(ar);

        System.out.println(Arrays.toString(ar));



    }

    // Time = 0(n)
    private static void orderArray(int[] arr)
    {
        // We maintain two pointer for even and odd and other section for unclassified

        int next_even = 0;
        int next_odd = arr.length-1;

        while(next_even<next_odd)
        {
            if(arr[next_even]%2==0)
            {
                next_even++;
            }
            else
            {
                // swap odd to next_odd
                int temp = arr[next_even];
                arr[next_even] = arr[next_odd];
                arr[next_odd] = temp;

                next_odd--;
            }
        }


    }
}
