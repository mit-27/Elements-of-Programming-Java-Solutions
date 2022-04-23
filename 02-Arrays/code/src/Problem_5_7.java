import java.util.Arrays;

public class Problem_5_7 {

    // BUY AND SELL A STOCK TWICE
    // Write a program that computes the maximum profit that can be made by buying and
    //selling a share at most twice. The second buy must be made on another date after the
    //first sale

    public static void main(String[] args) {
        int[] stocks = {12,11,13,9,12,8,14,13,15};
        System.out.println(maxStockProfitFromTwice(stocks));
    }

    // Time : 0(n)
    private static int maxStockProfitFromTwice(int[] stocks)
    {
        if(stocks.length==1)
        {
            // If stocks are only 1 then it's not possible
            return -1;
        }

        int maxTotalProfit=0;

        // To maintain second time sell profit
        int[] secondTimeProfit = new int[stocks.length];
        int maxStock=stocks[stocks.length-1];
        int maxProfit = 0;

        // To fill secondTimeProfit start from end
        for (int i = stocks.length-2; i >=0 ; i--) {

            // If stock[i]-maxStock > maxprofit then assign new maxProfit and store it at secondTImeProfit[i]
            maxStock = Math.max(maxStock,stocks[i]);
            maxProfit = Math.max(maxProfit,maxStock-stocks[i]);
            secondTimeProfit[i] = maxProfit;
        }

        System.out.println("SecondTime Profit Array : "+ Arrays.toString(secondTimeProfit));


        // Now here we go for first time buySell profit + secondtime Profit

        // for ith index firsttime[i]+secondTIme[i+1] where secondTIme[i+1] will contain maxProfit from [i+1,n]

        int minStock=stocks[0];
        for (int i = 0; i <stocks.length-1; i++) {
            minStock = Math.min(minStock,stocks[i]);

            int currentProfit = stocks[i]-minStock;

            maxTotalProfit = Math.max(maxTotalProfit,currentProfit+secondTimeProfit[i+1]);
        }







        return maxTotalProfit;
    }
}
