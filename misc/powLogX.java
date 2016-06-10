package Code;


/*
    Implement the power function in log n complexity

    2^8  = 2* 2^7

    2^8 = 2 2 2 2    2 2  2 2
        = 2^4  * 2^4

     3^0 = 1

     Time complexity : log x

*/


public class Solution {

    public static int pow(int a, int x)
    {
        if(x==0)
        return 1;

        int temp =pow(a,x/2);
        return (x%2==0) ? (temp*temp) :  (temp*temp*a);
    }

    public static void main(String args[]){
        System.out.println(pow(2,8));
        System.out.println(pow(3,0));
        System.out.println(pow(5,2));

    }




}
