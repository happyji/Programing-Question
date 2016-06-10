package Code;

//A Boolean Matrix Question



public class Solution {

    public static void Boolean01Change(boolean [][] mat)
    {
        boolean row[] = new boolean[mat.length];
        boolean col[] = new boolean[mat[0].length];

        for(int i=0; i< mat.length;i++)
        {
            for(int j=0; j< mat[i].length;j++)
            {
                if(mat[i][j] == true)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0; i< mat.length;i++)
        {
            for(int j=0; j< mat[0].length;j++)
            {
                if(row[i]== true || col[j]== true)
                {
                    mat[i][j] = true;
                }
            }
        }

        for(int i=0;i< mat.length;i++) System.out.print(row[i]);
        System.out.println();
        for(int i=0;i< mat[0].length;i++) System.out.print(col[i]);

    }


    public static void printMatrix(boolean [][] mat)
    {

        for(int i=0; i< mat.length;i++)
        {
            System.out.println();
            for(int j=0; j< mat[i].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
        }

    }



    public static void main(String args[]){
        boolean mat[][] = {
                {true,false,false,true},
                {false,false,true,false},
                {false,false,false,false},
                {false,false,false,false}
        };


        Boolean01Change(mat);
        printMatrix(mat);


    }




}
