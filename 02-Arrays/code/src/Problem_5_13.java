import java.util.Arrays;
import java.util.Random;

public class Problem_5_13 {

    // SAMPLE ONLINE DATA

    // Description : Design a program that takes as input a size k,and reads packets, continuously main¬
    //taining a uniform random subset of size k of the read packets.

    // Example
    // suppose k - 2, and the packets are read in the order p,q,r,t,u,v.
    //We keep the first two packets in the subset, which is {p,q}. We select the next packet, r,
    //with probability 2/3. Suppose it is not selected. Then the subset after reading the first
    //three packets is still {p,q}. We select the next packet, t, with probability 2/4. Suppose
    //it is selected. Then we choose one of the packets in (p,q) uniformly, and replace it
    //with t. Let q be the selected packet—now the subset is (p, t). We select the next packet
    //u with probability 2/5. Suppose it is selected. Then we choose one of the packets in
    //(p, t ) uniformly, and replace it with u. Let t be the selected packet—now the subset is
    //(p, u). We select the next packet v with probability 2/6. Suppose it is not selected. The
    //random subset remains (p,u).

    public static void main(String[] args) {

        int[] data = {1,5,4,7,8,9,3};

        System.out.println(Arrays.toString(onlineRandomSampling(data,2)));

    }

    // Time : 0(n) space = 0(k)
    private static int[] onlineRandomSampling(int[] data,int k)
    {
        // create array to store ans
        int[] ans = new int[k];

        // assign first k elements in ans
        for (int i = 0; i < k; i++) {
            ans[i]=data[i];
        }

        Random ran = new Random();

        // from [k,data.length-1] we select random number and if number is < k then we replace current i with k index
        for (int i = k; i < data.length; i++) {

            int replaceIndex = ran.nextInt(i+1); // which select from 0 to i

            if(replaceIndex<k)
            {
                // set ith index of answer element on replaceIndex
                ans[replaceIndex]=data[i];
            }

        }

        return ans;
    }



}
