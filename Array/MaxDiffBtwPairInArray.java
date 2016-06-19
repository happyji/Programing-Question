import java.util.*;


//Given an array find the max difference between any pair. with minimum comparision

public class Solution {

    public static void printMaximumDiferencePair(List<Integer> arr)
    {


        if(arr.size()>=2)
        {
            int min,max;
            if (arr.get(0)>arr.get(1))
            {
                max = arr.get(0);
                min = arr.get(1);
            }
            else
            {
                min = arr.get(0);
                max = arr.get(1);
            }

            if(arr.size() == 2)
            {
                System.out.println(max-min);
                return;
            }

            int x,y;
            for(int i=2;i<= arr.size()-2;i= i+2)
            {
                if(arr.get(i) > arr.get(i+1))
                {
                    x= arr.get(i);
                    y= arr.get(i+1);
                }
                else
                {
                    y= arr.get(i);
                    x= arr.get(i+1);
                }

                if(x > max) max=x;
                if(y< min) min=y;
            }
            System.out.println(max-min);

        }

    }

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1,17,3,55,12,28);
        printMaximumDiferencePair(list);

    }



}
