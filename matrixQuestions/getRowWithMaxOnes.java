package Code;

public class Solution {

    public static int getRowWithMaxOnes(int arr[][],int m,int n){
            int i = 0;
            int j = n-1;
            int rowInx =-1;

            if(m<1 || n<1) return rowInx;

            while(i<m && j>=0)
            {
                if(arr[i][j]==1)
                {
                    j--;
                    rowInx = i;
                }
                else
                {
                    i++;
                }
            }

        return rowInx;
    }



    public static void main(String args[]){
        int arr [][] = {
                {0,0,0,0,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,1,1,1,1,1,1,1}
        };

        System.out.println(getRowWithMaxOnes(arr,4,8));

        int arr0 [][] = {
                {0,0,0},
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        System.out.println(getRowWithMaxOnes(arr0,4,3));

        int arr1 [][] = {
                {1,1,1},
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };


        System.out.println(getRowWithMaxOnes(arr1,4,3));

        int arr12 [][] = {
                {0,1,1},
                {0,0,0},
                {1,1,1},
                {0,1,1}
        };

        System.out.println(getRowWithMaxOnes(arr12,4,3));
    }

}
