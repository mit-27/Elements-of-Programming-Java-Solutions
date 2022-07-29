public class Problem_11_6 {

    // SEARCH IN A 2D SORTED ARRAY

    // Design an algorithm that takes a 2D sorted array and a number and checks whether
    //that number appears in the array. For example, if the input is the 2D sorted array in
    //Figure12.3 on the next page, and the number is 7, your algorithm should return false;
    //if the number is 8, your algorithm should return true.

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {-1,2,4,4,6},
                {1,5,5,9,21},
                {3,6,6,9,22},
                {3,6,8,10,24},
                {6,8,9,12,25},
                {8,10,12,13,40}
        };

        int target = 25;
        System.out.println(target + " is present : "+isPresent(arr,target));
    }

    // Time 0(m+n) m=no of rows and n=no of cols
    static boolean isPresent(int[][] arr,int target)
    {
        // Here lower bound would be startRow and upperBound is lastRow
        int sr=0,lc=arr[0].length-1;

        while(sr<arr.length && lc>=0)
        {
            // every iteration we will element either row or col
            if(arr[sr][lc]==target)
            {
                return true;
            }
            else if(arr[sr][lc]>target)
            {
                // it means lc's all element would be > target so decrement lc
                lc--;
            }
            else
            {
                // it means sr's all element < target so increment sr
                sr++;
            }
        }

        // till not found return false
        return false;
    }
}
