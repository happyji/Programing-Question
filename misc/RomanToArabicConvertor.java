package Code;

import java.lang.*;
import java.util.HashMap;


public class TestClass
{

    static HashMap<String,Integer> map;

    static boolean isValidEntry(char[] roman,int i,int len)
    {

        if(map.get(String.valueOf(roman[i+1])) <= map.get(String.valueOf(roman[i])))
            return false;
        else
            return true;


    }

    static void init()
    {
        map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
    }

    static int getArabicValue(char[] input)
    {
        int i=0;
        int result =0;
        while (i< input.length)
        {
            if(i+1< input.length && isValidEntry(input,i,input.length))
            {
                 String token = input[i]+""+input[i+1];
                 result+= map.get(token);
                 i+=2;
            }
            else
            {
                result+= map.get(String.valueOf(input[i]));
                i++;
            }

        }

        return result;
    }

    public static void main(String args[]) throws Exception
    {

        init();
        String str = "MMMDXLIX";
        char[] input = str.toCharArray();

        System.out.println(getArabicValue(input));


    }

}







