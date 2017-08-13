package Code;



public class Knapsack01 {


    /*

            0   1   2   3   4   5   6   7
        
        0   0   0   0   0   0   0   0   0

        1   0
        
        4   0

        5   0

        7   0



    */

    
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
         int [] weight = {1,3,4,5};
         int [] value = {1,4,5,7};

        System.out.println(get01KnapSack(weight,value,7));

    }
}
