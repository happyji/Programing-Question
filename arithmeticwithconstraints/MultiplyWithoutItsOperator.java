package arithmeticwithconstraints;
import java.util.*;

public class MultiplyWithoutItsOperator {

    public static int multiply(int a,int b){
        int ans = 0;
        while (a != 0){

            if((a & 1) != 0){
                ans += b;
            }

            a >>= 1;
            b <<= 1;
        }
        return ans;

    }


    public static void main(String args[]){
        Integer a = 12;
        //System.out.println(Integer.toBinaryString(a));
        //System.out.println(a&1);
        System.out.println(multiply(21,15));
    }

}
