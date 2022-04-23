import java.util.Arrays;

public class Problem_5_2 {

    //INCREMENT AN ARBITRARY-PRECISION INTEGER

//    Write a program which takes as input an array of digits encoding a decimal number
//    D and updates the array to represent the number D + 1

    public static void main(String[] args) {

        int[] testArr = {1,9,9,8};
        int[] ans = plusOne(testArr);

        System.out.println(Arrays.toString(ans));


    }

    // Time = 0(n)
    public static int[] plusOne(int[] arr)
    {
        int carry=0;
        int add=1;
        for(int i=arr.length-1;i>=0;i--)
        {
            arr[i] = arr[i]+add + carry;

            // after adding 1
            add =0;

            if(arr[i]>9)
            {
                // it means after adding 1 it will become 10
                arr[i]=0;
                carry=1;
            }
            else
            {
                // after adding its lesser than 9
                // no need to compute further
                carry=0;
                break;
            }
        }

        // After adding 1 if carry is 1 then we have to create new array
        // Exp : 9999 => 10000
        if(carry==1)
        {
            int[] newArr = new int[arr.length+1];
            newArr[0]=1;
            return newArr;
        }

        return arr;

    }
}
