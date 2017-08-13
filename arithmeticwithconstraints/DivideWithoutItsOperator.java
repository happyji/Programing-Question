package arithmeticwithconstraints;
import java.util.*;

public class DivideWithoutItsOperator {

    public static int divide(int divident,int divisor){

        if(divisor==0)
            return -1;

        if(divident < divisor)
            return  0;

        if(divident == divisor)
            return  1;


        int current = 1;
        int den = divisor;

        while (divident > den)
        {
            den = den <<1;
            current = current<<1;
        }

        den = den>>1;
        current = current>>1;


        return current + divide(divident-den,divisor);
    }


    public static void main(String args[]){
        Integer a = 12;
        //System.out.println(Integer.toBinaryString(a));
        //System.out.println(a&1);
        System.out.println(divide(21,15));

    }

}
