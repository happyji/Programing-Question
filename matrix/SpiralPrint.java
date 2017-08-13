package matrix;





public class SpiralPrint {








    public static void spiralMatrix(int mat[][], int m, int n)
    {
        int top=0;
        int btm=m-1;
        int lft=0;
        int rgt= n-1;
        int dir =0;

        while (top<= btm && lft<= rgt)
        {
            if(dir == 0)
            {
                for(int i = lft;i<= rgt;i++ )
                System.out.print(mat[top][i]+" ");

                top++;
                dir=1;
            }
            else if(dir == 1)
            {
                for(int i = top;i<= btm;i++ )
                    System.out.print(mat[i][rgt]+" ");

                rgt--;
                dir=2;
            }
            else if(dir == 2)
            {
                for(int i = rgt;i>=lft;i-- )
                    System.out.print(mat[btm][i]+" ");

                btm--;
                dir=3;
            }
            else
            {
                for(int i = btm;i>=top;i-- )
                    System.out.print(mat[i][lft]+" ");

                lft++;
                dir=0;
            }



        }

    }

    public static void main(String args[]){
        int mat[][]  = new int[][]{
                {1 ,2 ,3 ,4,5},
                {6 ,7 ,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        spiralMatrix(mat, 4, 5);



    }




}
