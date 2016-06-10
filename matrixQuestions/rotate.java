package Code;





public class Solution {

    public static void rotate90(int mat[][]){
         int n = mat.length;

        for(int cover=0;cover< n/2;cover++)
        {
            int first = cover;
            int last = n-1-cover;

            for (int k=0;k< last;k++)
            {
                int diff = k-first;
                int temp = mat[first][k];
                mat[first][k] = mat[last-diff][first];
                mat[last-diff][first] = mat[last][last-diff];
                mat[last][last-diff] = mat[k][last];
                mat[k][last] = temp;
            }

        }
    }




    public static void rotate(int mat[][]){

        for(int i=0 ;i< mat.length;i++)
        {
            for(int j=0; j< i; j++){

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }

        for(int i=0 ;i< mat.length;i++)
        {
            int n = mat.length;
            for(int j=0; j< (n/2); j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }



        printMatrix(mat);
    }

    public static void printMatrix(int mat[][])
    {
        System.out.println();
        for (int i=0; i< mat.length;i++)
        {
            System.out.println();
            for (int j=0; j< mat.length; j++)
            {
                System.out.print(mat[i][j]+" ");
            }
        }
    }

    public static void main(String args[]){
        int mat[][]  = new int[][]{
                {1 ,2 ,3 ,4 },
                {5 ,6 ,7 ,8 },
                {9 ,10,11,12},
                {13,14,15,16}
        };
        printMatrix(mat);
        /*
        rotate90(mat);
        printMatrix(mat);*/

        rotate(mat);



    }




}
