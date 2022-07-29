public class Problem_11_3 {

    // SEARCH A CYCLICALLY SORTED ARRAY

    // Design an 0(log n) algorithm for finding the position of the smallest element in a
    //cyclically sorted array. Assume all elements are distinct.

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,2};

        System.out.println(getSmallestElement(arr));

        System.out.println(getKeyElementPosition(arr,2));
    }

    static int getSmallestElement(int[] arr)
    {
        int left=0,right=arr.length-1;

        while(left<right)
        {
            int m = left + (right-left)/2;

            if(arr[m]>arr[right])
            {
                // it means m+1 to right is not in increasing order
                // Its decrease then it means smallest value would be right side
                // as Decrease order second value would be smallest value
                left = m+1;
            }
            else
            {
                // right side is increase order so go left but it could possible that middle value could be
                // answer
                right = m;
            }

        }

        return left;
    }

    static int getKeyElementPosition(int[] arr,int key)
    {
        int left=0,right=arr.length-1;

        while(left<=right)
        {
            int m = left + (right-left)/2;

            if(arr[m]==key)
            {
                return m;
            }
            else if(arr[m]<arr[right])
            {
                // m in right side which is in increase order
                if(key>arr[m] && key<=arr[right])
                {
                    left = m+1;
                }
                else{
                    right = m-1;
                }
            }
            else{
                // m in resides in left side where m's right side has smaller values
                if(key<=arr[right])
                {
                    left = m+1;
                }
                else
                {
                    right = m-1;
                }
            }

        }

        return -1;
    }
}
