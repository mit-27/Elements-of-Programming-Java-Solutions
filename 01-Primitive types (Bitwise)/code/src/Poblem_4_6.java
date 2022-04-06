import java.util.Scanner;

public class Poblem_4_6 {

    // compute x/y

    // Algorithm : Time complexity 0(n)
    // While x>=y
    // 1. Find largest k such that (2^k)y<=x
    // 2. Add 2^k to quotient (Ans)
    // 3. Subtract (2^k)y from x which becomes new x

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        long x,y;
        x=sc.nextLong();
        y=sc.nextLong();

        long ans = divide(x,y);

        System.out.println("Answer : "+ans);

    }

    private static long divide(long x,long y)
    {
        // First start k=32
        int power = 32;
        // ypower=2^ky where power=k
        long ypower = y<<power;

        long result = 0;

        while(x>=y)
        {
            // Here we find largest k where 2^ky<=x
            while(ypower>x)
            {
                // Decrease k and 2^ky
                ypower = ypower>>1;
                --power;
            }

            // We found largest k so add 2^k to result
            result= result + 1L<<power;

            // Subtract 2^ky from x
            x = x - ypower;

        }

        return result;



    }
}
