public class Problem_5_17 {

    // THE SUDOKU CHECKER PROBLEM

    // Check whether a 9 X 9 2D array representing a partially completed Sudoku is valid.
    //Specifically, check that no row, column, or 3 X 3 2D subarray contains duplicates. A
    //0-value in the 2D array indicates that entry is blank; every other entry is in [1,9].

    public static void main(String[] args) {

        int[][] sudoku = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        if(checkSudoku(sudoku))
        {
            System.out.println("Sudoku is valid");
        }
        else
        {
            System.out.println("Sudoku is invalid");
        }

    }

    private static boolean hasDuplicates(int[][] sudoku,int startRow,int endRow,int startCol,int endCol)
    {
        boolean[] presentNumbers = new boolean[10];
        for (int i = startRow; i < endRow; i++) {
            for (int j=startCol;j<endCol;j++)
            {
                if(sudoku[i][j]!=0 && presentNumbers[sudoku[i][j]])
                {
                    return true;
                }
                else
                {
                    presentNumbers[sudoku[i][j]]=true;
                }
            }
        }

        return false;
    }

    // Time = 0(n^2)
    private static boolean checkSudoku(int[][] sudoku)
    {

        // To check all rows
        for (int i = 0; i < sudoku.length; i++) {
            if(hasDuplicates(sudoku,i,i+1,0, sudoku.length))
            {
                // if this true it means sudoku is invalid and numbers repeated in row
                return false;
            }
        }

        // to check all cols
        for (int i = 0; i < sudoku.length; i++) {
            if(hasDuplicates(sudoku,0, sudoku.length, i, i+1))
            {
                // if this true it means sudoku is invalid and numbers repeated in col
                return false;
            }
        }

        // to check regional sudokus of size 3
        int regionalSize = (int)Math.sqrt(sudoku.length);

        // we should follow this
        // (0,3,0,3) (0,3,3,6) (0,3,6,9)
        //(3,6,0,3) (3,6,3,6) (3,6,6,9)
        //(6,9,0,3) (6,9,3,6) (6,9,6,9)

        for (int i = 0; i < regionalSize; i++) {
            for (int j=0;j<regionalSize;j++)
            {
                if(hasDuplicates(sudoku,i * regionalSize,(i+1)*regionalSize,j*regionalSize,(j+1)*regionalSize))
                {
                    // this subsudoku contains duplicate number
                    return false;
                }
            }
        }

        // if not return till now it means its valid
        return true;

    }


}
