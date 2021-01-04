package dynamicprogramming;



/*
        knapsack(item,wt)  =

        wt ==0   :  0
        item

        max(knapsack(item-1,wt), value[item] + knapsack(item-1,wt-weight[item]))



 */


import java.util.HashMap;
import java.util.Map;

public class Knapsack01 {

    public static int getKnapSack(int weight[],int value[],int item,int wt){

        if(wt == 0 || item == 0)
            return 0;

        if(weight[item-1] > wt)
            return getKnapSack(weight,value,item-1,wt);


        int dntPick = getKnapSack(weight,value,item-1,wt);
        int pick=  (value[item-1])  + getKnapSack(weight,value,item -1,wt-weight[item-1]);

        return Math.max(dntPick,pick);
    }

    public static int getKnapSackUnbound(int weight[],int value[],int item,int wt){

        if(wt == 0 || item == 0)
            return 0;

        if(weight[item-1] > wt)
            return getKnapSack(weight,value,item-1,wt);


        int dntPick = getKnapSack(weight,value,item-1,wt);
        int pick=  (value[item-1])  + getKnapSack(weight,value,item ,wt-weight[item-1]);

        return Math.max(dntPick,pick);
    }

    public static int getKnapSackMem(int[] weight, int[] value, int item, int wt, Map<String, Integer> map){

        if(wt == 0 || item == 0)
            return 0;

        String key = String.format("%s-%s",item,wt);
        System.out.println("Searching :" + key);

        if (map.containsKey(key)){
            System.out.println("Hit : "+ map.get(key));
            return map.get(key);
        }

        System.out.println("Calculating :" + key);
        if(weight[item-1] > wt){
            int ans = getKnapSackMem(weight,value,item-1,wt,map);
            map.put(key,ans);
            return ans;
        }



        int dntPick = getKnapSackMem(weight,value,item-1,wt,map);
        int pick=  (value[item-1])  + getKnapSackMem(weight,value,item -1,wt-weight[item-1],map);

        int ans = Math.max(dntPick, pick);
        map.put(key,ans);
        return ans;
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

        //System.out.println("Bound :" + getKnapSack(weight,value,weight.length,20));
        //System.out.println("UnBound :" + getKnapSackUnbound(weight,value,weight.length,20));

        Map<String,Integer> map = new HashMap<>();
        System.out.println("Bound Memorization:" + getKnapSackMem(weight,value,weight.length,20,map));
       // System.out.println(getKnapSack(weight,value,weight.length-1,20));
    }
}
