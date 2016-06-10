package Code;

   /*
         * Given a total and coins of certain denomination with infinite supply, what is the minimum number
         * of coins it takes to form this total.
         *
         * Time complexity - O(coins.size * total)
         * Space complexity - O(coins.size * total)
         *
    */


public class Solution {

    public static void printArray(int arr[]){
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }

    public static int getMinNoOfCoin(int[] coins,int total){
        int DP[] = new int[total+1];
        int BDP[] = new int[total+1];
        for(int i=1;i<= total;i++){
            DP[i]=Integer.MAX_VALUE;
            BDP[i]=-1;
        }

        for(int p=0;p<coins.length;p++)
        {
            for(int i=1;i<=total;i++)
            {
                   /*
                        note here below code will not work
                        1+ Int.maz will become least max  ;)
                        if(i >=coins[p])

                   */
                    if(i >=coins[p]){
                        int temp = DP[i-coins[p]]==Integer.MAX_VALUE ? DP[i-coins[p]] : DP[i-coins[p]]+1;
                        if(temp<DP[i]){
                           DP[i] = temp;
                           BDP[i] = p;
                        }

                    }

            }


        }

        showCoinsRequired(coins, total, DP, BDP);


        return DP[total-1];
    }

    private static void showCoinsRequired(int[] coins, int total, int[] DP, int[] BDP) {
        printArray(DP);
        printArray(BDP);
        System.out.println();

        int n = total;
        while (true){
            int reqCoin = BDP[n];
            System.out.print(" "+coins[reqCoin]+" ");
            n= n- coins[reqCoin];

            if(n<=0) break;
        }
    }

    public static void main(String args[]){
        int coin[]={7,2,3,6};
        getMinNoOfCoin(coin, 13);
    }

}
