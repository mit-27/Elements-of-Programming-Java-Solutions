public class Problem_5_6 {

    // Buy and Sell stock once

    //Write a program that takes an array denoting the daily stock price, and returns the
    //maximum profit that could be made by buying and then selling one share of that
    //stock.

    public static void main(String[] args) {

        int[] stocks = {310,315,275,295,260,270,290,230,255,250};
        System.out.println(maxStockProfit(stocks));

        int[] arr = {1,1,2,2,2,3,3,4,5,5,5,5,5};
        System.out.println(longestSubArray(arr));

    }

    // Time : 0(n)
    private static int maxStockProfit(int[] stocks)
    {
        int maxProfit=0;
        int minStockPrice=stocks[0];

        if(stocks.length==1)
        {
            // If stocks are only 1 then it's not possible
            return -1;
        }

        for(int i=1;i<stocks.length;i++)
        {
            // Here we compare profit for maxProfit
            if(stocks[i]>minStockPrice && (stocks[i]-minStockPrice)>maxProfit)
            {
                maxProfit = stocks[i]-minStockPrice;
            }
            if(stocks[i]<minStockPrice)
            {
                // If lesser than minStock then assign to minStock
                minStockPrice = stocks[i];
            }
        }

        return maxProfit;
    }

    // Variant :
    // Write a program that takes an array of integers and finds the length of a
    //longest subarray all of whose entries are equal.

    // Time : 0(n)
    private static int longestSubArray(int[] arr)
    {
        // To tract current long
        int currentLong=1;
        // To track actual answer which is maximum
        int maxLong = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[i-1])
            {
                // continue current long length increment
                currentLong++;
            }
            else
            {
                // compare cuurentlong and assign to max if its longest till now
                if(currentLong>maxLong)
                {
                    maxLong = currentLong;
                }
                currentLong=1;
            }
        }

        if(currentLong>maxLong)
        {
            maxLong = currentLong;
        }

        return maxLong;
    }

}
