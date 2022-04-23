import java.util.Arrays;

public class Problem_5_18 {

    // COMPUTE THE SPIRAL ORDERING OF A 2D ARRAY

    public static void main(String[] args) {

        int[][] arr = {
                {1,3,5,7},
                {7,9,8,1},
                {0,2,4,0}
        };

        System.out.println(Arrays.toString(getSpiralOrder(arr)));

    }

    private static int[] getSpiralOrder(int[][] arr)
    {
        int totalElements = arr.length * arr[0].length;
        int[] answer = new int[totalElements];

        // for direction
        boolean horizontalTraversal = true;
        boolean toright = true;
        boolean tobottom = true;

        int count = 0;

        // To tract max row and col
        int maxRow = arr.length-1;
        int maxCol = arr[0].length -1;
        int minRow = 0;
        int minCol = 0;

        int currentRow=0;
        int currentCol=0;

        while(count<totalElements)
        {
            if(horizontalTraversal)
            {
                if(toright)
                {
                    // left to right traversal in row
                    while(currentCol<=maxCol)
                    {
                        answer[count++] = arr[currentRow][currentCol];
                        currentCol++;
                    }
                    currentCol--;
                    // now we start with next row so inc currentrow
                    currentRow++;

                    // here minRow should increment as we traveled that row
                    minRow++;

                    toright=false;
                }
                else
                {
                    // Right to left row traversal
                    while(currentCol>=minCol)
                    {
                        answer[count++] = arr[currentRow][currentCol];
                        currentCol--;
                    }
                    currentCol++;
                    // we start with previous row
                    currentRow--;
                    // Here maxRow should decrement as we traveled that row
                    maxRow--;

                    toright=true;
                }
                horizontalTraversal=false;
            }
            else
            {
                if(tobottom)
                {
                    while(currentRow<=maxRow)
                    {
                        answer[count++] = arr[currentRow][currentCol];
                        currentRow++;
                    }
                    currentRow--;
                    // now we start with previous col
                    currentCol--;
                    // Here maxCol should decrement as we travelled last col first
                    maxCol--;

                    tobottom=false;
                }
                else
                {
                    while(currentRow>=minRow)
                    {
                        answer[count++] = arr[currentRow][currentCol];
                        currentRow--;
                    }
                    currentRow++;
                    // Here maxCol should decrement as we travelled last col first
                    // now we start with next col
                    currentCol++;
                    minCol++;
                    tobottom=true;
                }


                horizontalTraversal=true;
            }
        }

        return answer;


    }
}
