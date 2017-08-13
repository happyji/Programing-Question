package arithmeticwithconstraints;
import java.util.*;

public class AddWithoutUsingPlusOperator {

    public  static  int add(int x, int y)
    {
        while (y!= 0)
        {
            // half adder logic
            int carry = x&y;
            x = x^y;
            y = carry <<1;

        }
        return x;
    }


    public static void main(String args[]){
        System.out.println(add(10,12));
    }

}
