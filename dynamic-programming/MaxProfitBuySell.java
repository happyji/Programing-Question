package Code;
import java.util.*;



public class MaxProfitBuySell {

    public static void maxProfitBuySell(int price[], int k)
    {
        int profit[][] = new int[k+1][price.length];

        for(int transaction=1;transaction<= k;transaction++)
        {
            for(int sellDay=1; sellDay< price.length;sellDay++)
            {

                int tradeProfit = Integer.MIN_VALUE;

                int notTradeProfit = profit[transaction][sellDay-1];

                for(int dayToBuy=0; dayToBuy < sellDay;dayToBuy++)
                {
                    int tempProfit = (price[sellDay]-price[dayToBuy]) + profit[transaction-1][dayToBuy];
                    if(tempProfit > tradeProfit)
                        tradeProfit = tempProfit;
                }

                profit[transaction][sellDay] = Math.max(tradeProfit,notTradeProfit);
            }
        }

        System.out.println(profit[k][price.length-1]);

    }

    public static void main(String args[]){
        int arr[] = {2,5,7,1,4,3,1,3};
        maxProfitBuySell(arr,3);


    }




}
