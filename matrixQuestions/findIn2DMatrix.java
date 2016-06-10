package Code;

public class Solution {

    public static boolean findIn2Dmatrix(int [][] mat,int m,int n,int key){
        int i=0;
        int j=n-1;

        while (i< m && j>= 0)
        {

            if(key == mat[i][j])
                return true;
            else if(key> mat[i][j])
                i++;
            else
                j--;
        }

        return false;
    }


    public static void main(String args[]){
        int mat[][] = {
                {1,3,4,7},
                {2,4,5,8},
                {5,8,9,12}
        };

        System.out.println(findIn2Dmatrix(mat,3,4,5));

    }

}
