package array;


/*
   Given two sorted arrays, find their union and intersection.

    For example, if the input arrays are:
    arr1[] = {1, 3, 4, 5, 7}
    arr2[] = {2, 3, 5, 6}
    Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.




*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArray {

    public static List<Integer> intersection(List<Integer> a1,List<Integer> a2)
    {
        List<Integer> a3 = new ArrayList<Integer>();

        int i=0;
        int j=0;

        while (i < a1.size() && j < a2.size())
        {
            if(a1.get(i)== a2.get(j)) // element is common in both arrays then put in resultArray   
                a3.add(a1.get(i));

            if(a1.get(i)< a2.get(j))  // array's index whose element is smaller will increase itself
                i++;
            else
                j++;
        }

        return a3;
    }


    public static void main(String args[]){
        List<Integer> a1 = Arrays.asList(1, 3, 4, 5, 7);
        List<Integer> a2 = Arrays.asList(2, 3, 5, 6);

        List<Integer> a3 = intersection(a1,a2);
        a3.forEach(i->System.out.print(i+" "));


    }




}
