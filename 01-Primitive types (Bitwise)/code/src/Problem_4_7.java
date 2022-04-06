import java.util.Scanner;

public class Problem_4_7 {

    //  compute x^y



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x;
        int y;
        x=sc.nextDouble();
        y=sc.nextInt();

        double ans = powerBitwise(x,y);
        System.out.println("Answer : "+ans);

    }

    // Time complexity = 0(n) where n is bits in y
    private static double powerBitwise(double x, int y) {
        double result = 1;
        // for y negative
        if(y<0)
        {
            y = y * (-1);
            x = 1/x;
        }

        while(y>0)
        {
            if((y&1)==1)
            {
                result = result * x;
            }

            y = y>>1;
            // We perform right shift so we have to multiply x so that in next result = x * x^2
            x = x*x;

        }

        return result;
    }
}
