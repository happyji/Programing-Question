package Code;

class Point
{
    int x;
    int y;

    Point(int a,int b){
        x=a;
        y=b;
    }
}



public class Solution {


    public static boolean isOverlap(Point l1,Point r1,Point l2,Point r2)
    {
        if(l1.x > r2.x || l2.x> r1.x)
            return false;

        if(r2.y> l1.y || r1.y > l2.y)
            return false;

        return true;
    }



    public static void main(String args[]){
            Point l2 = new Point(2,5);
            Point r2 = new Point(5,2);

            Point l1 = new Point(2,13);
            Point r1 = new Point(5,7);

            System.out.println(isOverlap(l1,r1,l2,r2));

            l2 = new Point(2,5);
            r2 = new Point(5,2);

            l1 = new Point(3,7);
            r1 = new Point(7,4);


        System.out.println(isOverlap(l1,r1,l2,r2));
    }




}
