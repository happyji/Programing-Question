package Code;


import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public  static HashSet<String> hashSet  = new HashSet<>();
    public static int count = 0;

    public static void print(boolean[] temp,int arr[])
    {

        if(!hashSet.contains(temp.toString()))
        {
            System.out.print("{");
            for (int i=0;i< temp.length;i++)
            {

                if(temp[i]== true)
                {
                   System.out.print(arr[i]);
                }

            }
            System.out.print("}");
            hashSet.add(temp.toString());
            count++;
        }
    }

    public static void  permutate(int []arr,boolean []temp,int index)
    {

        if(index== arr.length)
            return;

        temp[index] = true;
        boolean arr1[] = Arrays.copyOf(temp,temp.length);
        print(temp,arr);
        temp[index] = false;
        boolean arr2[] = Arrays.copyOf(temp,temp.length);
        print(temp,arr);


        permutate(arr, arr1,index+1);
        permutate(arr,arr2,index+1);
    }


    public static void main(String args[]){
        int arr[] ={1,2,3,4};
        boolean temp[] = new boolean[arr.length];
        permutate(arr,temp,0);
        System.out.println("Total permutation : "+ count+1);


    }

}
