import java.util.Arrays;

public class Problem_5_19 {

    // ROTATE A 2D ARRAY

    // Write a function that takes as input an n X n 2D array, and rotates the array by
    //90 degrees clockwise.

    public static void main(String[] args) {

        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotateArray(mat);

        System.out.println("Rotated Matrix : ");
        for(int[] row : mat)
        {
            System.out.println(Arrays.toString(row));
        }

    }

    // Time 0(n^2) and Space 0(1)
    private static void rotateArray(int[][] matrix)
    {
        // We use Top,Bottom,Left,Right to use 4 way swap
        int left=0;
        int right = matrix.length-1;

        while(left<right)
        {
            // because of square matrix left==Top and right=Bottom
            int top = left;
            int bottom = right;

            // loop to swap no of elements from outer layers. In each iteration for loop swap inner layer
            for(int i=0;i<(right-left);i++)
            {
                // TopLeft element and after every i it will go right side
                int topLeft = matrix[top][left+i];

                // TopRight element and after every i it will go bottom
                int topRight = matrix[top+i][right];

                // BottomLeft element and after every i it will go up
                int bottomLeft = matrix[bottom-i][left];

                // BottomRight element and after every i it will go left side
                int bottomRight = matrix[bottom][right-i];

                // Now assign and perform swap

                // topLeft of matrix will assign bottomLeft
                matrix[top][left+i] = bottomLeft;

                // topRight of matrix will assign topLeft
                matrix[top+i][right] = topLeft;

                // bottomRight of matrix will assign topRight
                matrix[bottom][right-i] = topRight;

                // bottomLeft of matrix will assign bottomRight
                matrix[bottom-i][left] = bottomRight;




            }


            left++;
            right--;
        }

    }
}
