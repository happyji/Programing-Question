package Code;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.*;


/*
    Given a positive integer n, generate all possible unique ways to represent n as sum of positive integers.
      Input: n = 2
      Output:
      2
      1 1

      Input: n = 3
      Output:
      3
      2 1
      1 1 1
      Note: 2+1 and 1+2 are considered as duplicates.

      Input: n = 4
      Output:
      4

      3 1

      2 2
      2 1 1

      1 1 1 1

      1 2 1

 */





public class TestClass
{
    static void printPattern(int m,String str)
    {
        if(m==0)
            return;

        System.out.println(m+str);

        for(int i=1;i<= m/2;i++)
        {
            int x = str!= "" ? Character.getNumericValue(str.charAt(0)) : 0;
            if(m-i>=x)
            printPattern(m-i,String.valueOf(str+i));
        }
    }

    public static void main(String args[]) throws Exception
    {
        printPattern(4,"");
    }


}







