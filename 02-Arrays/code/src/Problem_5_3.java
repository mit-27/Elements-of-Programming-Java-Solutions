import java.util.Arrays;

public class Problem_5_3 {

    // Problem : Multiply two arbitay-precision integer

    public static void main(String[] args) {

        int[] x = {1,2,3};
        int[] y = {-1,1};

        int[] ans = multiplyArray(x,y);

        System.out.println(Arrays.toString(ans));

    }

    public static int[] multiplyArray(int[] x,int[] y)
    {
        // after multiplication max answer could be x.length+y.length
        int[] answer = new int[x.length+y.length];

        int sign = (x[0]/Math.abs(x[0])) * (y[0]/Math.abs(y[0]));

        x[0] = Math.abs(x[0]);
        y[0] = Math.abs(y[0]);


        // Suppose x=123 y=89
        // 123 * 9 + 123 * 8 * 10

        // for x in reverse
        for(int i=x.length-1;i>=0;i--)
        {
            // y in reverse
            for(int j=y.length-1;j>=0;j--)
            {
                answer[i+j+1] = answer[i+j+1]+ (x[i] * y[j]);

                answer[i+j] = answer[i+j] + (answer[i+j+1])/10;

                answer[i+j+1] = answer[i+j+1]%10;
            }
        }

        // add sign
        for(int i=0;i<answer.length;i++)
        {
            if(answer[i]!=0)
            {
                answer[i] = sign * answer[i];
                break;
            }
        }



        return answer;

    }

}
