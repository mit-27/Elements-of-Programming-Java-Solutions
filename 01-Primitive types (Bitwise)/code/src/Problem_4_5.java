import java.util.Scanner;

public class Problem_4_5 {

    // Compute x * y without arithmetic operators

    // 0(n^2) time complexity

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long x,y;
        x= sc.nextLong();
        y = sc.nextLong();

        // iterate through bits of x and add y<<k to answer

        long ans=0;
        while(x!=0)
        {
            if((x&1)==1)
            {
                ans = sumOfNum(ans,y);
            }
            x=x>>1;
            y=y<<1;

        }

        System.out.println("Answer : "+ans);


    }

    private static long sumOfNum(long a,long b)
    {
        long temp_a=a,temp_b=b,carryin=0,k=1,finalSum=0;
        while(temp_a!=0 || temp_b!=0)
        {
            // extract at position bit
            long ak=a&k,bk=b&k;

            // To check whether carry will appear we will use and
            carryin = (ak & bk) | (ak&carryin) | (bk&carryin);

            // To add we use xor
            finalSum = finalSum | (ak^bk^carryin);

            // In next step, to extract next rightmost bit we have to change k and carryin
            carryin = carryin << 1;
            k = k << 1;

            // To track whether a and b bits completed or not
            temp_a = temp_a >> 1;
            temp_b = temp_b >> 1;
        }

        return finalSum | carryin;


    }
}
