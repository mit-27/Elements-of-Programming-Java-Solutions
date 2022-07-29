public class Problem_11_5 {

    // COMPUTE THE REAL SQUARE ROOT

    // Implement a function which takes as input a floating point value and returns its
    //square root.

    public static void main(String[] args) {
        double k = 36;
        System.out.println(getSquareRoot(k));
    }

    static double getSquareRoot(double k)
    {
        double left,right;

        // decide search range according to k's value relative to 1.0
        if(k<1.0)
        {
            left = k;
            right=1.0;
        }
        else
        {
            left=1.0;
            right = k;
        }


        // Search as long as left<right
        while(compare(left,right)==Ordering.SMALLER)
        {
            double m = left + 0.5 * (right-left);

            double mSquare = m * m;

            if(compare(mSquare,k)==Ordering.EQUAL)
            {
                return m;
            }
            else if(compare(mSquare,k)==Ordering.LARGER)
            {
                right = m;
            }
            else
            {
                left =m;
            }
        }

        return left;

    }

    private static enum Ordering {SMALLER,EQUAL,LARGER};

    private static Ordering compare(double a,double b)
    {
        final double EPSILON = 0.00001;
        // uses normalization for precision problem
        double diff = (a-b)/b;

        return diff < -EPSILON ? Ordering.SMALLER : (diff>EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }
}
