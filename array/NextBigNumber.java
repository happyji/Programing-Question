package array;

import java.util.Stack;

public class NextBigNumber {

    /*
        test case :
        1 2 3 4 5 6 7      2 3 4 5 6 7 -1
        10 9 8 7 6 5       -1 -1 -1 -1 -1 -1
        10 9 11 8 12 7      11   11   12  12   -1   -1
        10 10 10 10 10      -1 -1 -1 -1 -1
        10                   -1
        12 10
        10 12


    */

    public static void nextBigNumber(int[] arr){
        int len = arr.length-1;

        Stack<Integer> stack = new Stack();
        stack.push(Integer.MIN_VALUE);
        int []result = new int[arr.length];

        for(int i=len;i>=0;i--)
        {
            while (!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();


            if(stack.isEmpty())
                result[i]=-1;
            else
                result[i] = stack.peek();


            stack.push(arr[i]);

        }

        for(int k=0;k<result.length;k++)
            System.out.print(result[k]+" ");

    }

    public static void main(String args[]){

        //test  case
        //int arr[] = {10,9,8,10,11};
        //int arr[] = {10,9,8,7,6,5};
        //int arr[] = {1 ,2 ,3 ,4 ,5 ,6 ,7};
        //int arr[] = {10 ,10 ,10 ,10 ,10};
        //int arr[] = {10};
        //int arr[] = {10,12};
        int arr[] = {12,10};
        nextBigNumber(arr);


    }

}
