package array;

import java.util.*;
import java.lang.*;
import java.io.*;



public class MaxNonRepetitiveSubString
{


    static int getMaxNonRepetitiveChar(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(str.charAt(0),0);
        int result=-1;

        int i=1;
        int max =1;
        int startIndex =0;
        while (i< str.length())
        {
            Character currentChar = str.charAt(i);
            if(map.containsKey(currentChar))
            {
                if(map.get(currentChar) >= startIndex)
                {
                    map.replace(currentChar,i);
                    startIndex = i;
                    if(max > result)
                        result = max;

                    max =1;
                }
            }
            else
            {
                map.put(currentChar,i);
                max++;
            }
            i++;
        }


        return result;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(getMaxNonRepetitiveChar("GEEKSFORGEEKS"));
    }
}
