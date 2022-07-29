public class Problem_11_8 {

    // FIND THE kth LARGEST ELEMENT

    // Design an algorithm for computing the kth largest element in an array. Assume
    //entries are distinct (Prefer using divide and conquer method)

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int k = 1;
        System.out.println("The "+k+"th Largest : "+findKthLargest(arr,k));
    }

    static int findKthLargest(int[] arr,int k)
    {
        // get target index from k (which is suppose after sorted array)
        int targetIndex = arr.length-k;

        // Its Divide and conquer method
        return quickSelect(arr,0,arr.length-1,targetIndex);


    }

    // TIme : avg case 0(n) and worst 0(n*n) and space would be constant
    static int quickSelect(int arr[],int left,int right,int targetIndex)
    {
        // start s pointer which points to index where all element on right would be < pivot
        // we select pivot from end

        int s=left;
        int pivotIndex = right;

        for (int i = left; i < right; i++) {

            if(arr[i]<=arr[pivotIndex])
            {
                // swap with s and increment s
                int t = arr[s];
                arr[s]=arr[i];
                arr[i]=t;
                s++;
            }

        }

        // now after this s's at correct position now swap s with pivotIndex so pivot would get at sorted position

        int temp = arr[pivotIndex];
        arr[pivotIndex]=arr[s];
        arr[s]= temp;

        // Here this index's element at its sorted position
        int sortedPivotIndex =s;

        // now compare targetIndex with sortedPivotIndex

        // Here left and right side of SortedPivotIndex is not sorted so if ans in those two part then we have to sort
        // those parts and repeat this procedure until sortedPivotIndex==targetIndex


        if(targetIndex < sortedPivotIndex)
        {
            // go right of sortedPivotIndex as left and right side of SortedPivotIndex is not sorted and ans index at right side
            return quickSelect(arr,left,sortedPivotIndex-1,targetIndex);
        }

        if(targetIndex>sortedPivotIndex)
        {
            // go right
            return quickSelect(arr,sortedPivotIndex+1,right,targetIndex);
        }

        // otherwise got answer as targetIndex==sortedPivotIndex
        return arr[sortedPivotIndex];


    }
}
