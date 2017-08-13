package dynamicprogramming;



/*
        knapsack(item,wt)  =

        wt ==0   :  0
        item

        max(knapsack(item-1,wt), value[item] + knapsack(item-1,wt-weight[item]))



 */


public class Knapsack01 {

    public static int getKnapSack(int weight[],int value[],int item,int wt){

        if(wt == 0 || item < 0)
            return 0;

        if(weight[item] >wt)
            return getKnapSack(weight,value,item-1,wt);


        int dntPick = getKnapSack(weight,value,item-1,wt);

        int pick=  (value[item])  + getKnapSack(weight,value,item-1,wt-weight[item]);

        return Math.max(dntPick,pick);
    }


    
    public static int get01KnapSack(int[] weight,int[] value,int total){
        int DP[][]= new int[weight.length+1][total+1];

        for(int i=0;i<=weight.length;i++)
        {
            for(int j=0; j<= total;j++)
            {
                if(i == 0 || j == 0){
                    DP[i][j] = 0;
                    continue;
                }

               if(j-weight[i-1] >=0)   //dont pick    //pick   -- select max
                   DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-weight[i-1]] + value[i-1]);
                else
                    DP[i][j] = DP[i-1][j];
            }
        }


        return DP[weight.length][total];
    }




    public static void main(String args[]){
         int [] weight = {1,3,4,5,8};
         int [] value = {1,4,5,7,15};

        System.out.println(get01KnapSack(weight,value,20));
        System.out.println(getKnapSack(weight,value,weight.length-1,20));
    }
}
