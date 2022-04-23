import java.util.ArrayList;

public class Problem_5_20 {

    // COMPUTE ROWS IN PASCAL'S TRIANGLE

    // Write a program which takes as input a nonnegative integer n and returns the first n
    //rows of Pascal's triangle.

    public static void main(String[] args) {

        int n = 5;
        System.out.println(getPascalTriangle(n));

        int nthRow=6;
        System.out.println(getNRowPascalTriangle(nthRow));

    }

    // Time 0(n) space 0(1)
    private static ArrayList<Integer> getNRowPascalTriangle(int n)
    {
        // for row every entry its nCi
        // Example n=5
        // 5C0 5C1 5C2 5C3 5C4 5C5
        //  1   5   10  10  5   1

        // For NCr = (NCr - 1 * (N - r + 1)) / r where 1 ≤ r ≤ N

        ArrayList<Integer> ans = new ArrayList<>();

        // nC0=1
        int prev = 1;

        ans.add(prev);

        for (int i = 1; i <=n; i++) {
            int curr = (prev * (n- i + 1)) / i;

            ans.add(curr);

            prev = curr;
        }

        return ans;
    }

    // Time : 0(n^2) and space 0(n^2)
    private static ArrayList<ArrayList<Integer>> getPascalTriangle(int rows)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            int j=0;
            ArrayList<Integer> row = new ArrayList<>();
            while(j<=i)
            {
                // for starting 1 and last 1
                if(j==0 || j==i)
                {
                    row.add(1);
                }
                else
                {
                    row.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
                j++;

            }
            ans.add(row);

        }

        return ans;
    }
}
