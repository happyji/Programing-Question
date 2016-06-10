package Code;


public class Solution {


    public static boolean isNonVisited(int x,int y,boolean  [][]visited)
    {
        return visited[x][y]==false;
    }

    public static boolean isLand(int x, int y, int [][]mat){
        return mat[x][y]==1;
    }

    public static boolean canGo(int x,int y, int [][]mat, boolean [][]visited)
    {
        int m = mat.length;
        int n = mat[0].length;

        if(x>=0 && y>= 0 &&x<m && y< n && isLand(x,y,mat) && isNonVisited(x,y,visited))
            return true;

        return false;
    }

    public static void GOTraverse(int x,int y, int [][]mat, boolean [][]visited)
    {
        int xAxis[]={1,1,1,0,-1,0,-1,0};
        int yAxis[]={1,0,-1,-1,-1,-1,1,1};

        for (int i=0;i <xAxis.length;i++)
        {


            int x1 = x+xAxis[i];
            int x2 = y+yAxis[i];
            visited[x][y]= true;
            if(canGo(x1,x2,mat,visited))
            {

               GOTraverse(x1,x2,mat,visited);
            }
        }

    }


    public static int countIsland(int mat[][])
    {
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        int count=0;
        for(int i=0; i< mat.length;i++){

            for(int j=0; j< mat[0].length;j++){
                  if(isLand(i,j,mat)&& isNonVisited(i,j,visited))
                  {
                      GOTraverse(i,j,mat,visited);
                      count++;

                  }

            }

        }





        return count;
    }


    public static void main(String args[]){
        int map[][] = new int[][]{
                {1,0,1,1,0,1},
                {1,0,0,1,0,0},
                {1,1,1,1,0,1},
                {1,0,0,1,0,0}
        };
        System.out.println(countIsland(map));

    }




}
